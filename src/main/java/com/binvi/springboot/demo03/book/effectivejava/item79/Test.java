package com.binvi.springboot.demo03.book.effectivejava.item79;

import com.google.common.collect.Sets;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/8 10:46
 */
public class Test {

	public static void main(String[] args) {
		test3();
	}

	private static void test1() {
		ObservableSet<Integer> set = new ObservableSet<>(Sets.newHashSet());
		set.addObserver((s, e) -> System.out.println(e));
		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}

	private static void test2() {
		ObservableSet<Integer> set = new ObservableSet<>(Sets.newHashSet());
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				if (element == 23) {
					set.removeObserver(this);
				}
			}
		});
		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}

	private static void test3 () {
		ObservableSet<Integer> set = new ObservableSet<>(Sets.newHashSet());
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(ObservableSet<Integer> s, Integer element) {
				System.out.println(element);
				if (element == 23) {
					ExecutorService executor = Executors.newSingleThreadExecutor();
					try {
						executor.submit(() -> { s.removeObserver(this); }).get();
					} catch (ExecutionException | InterruptedException e) {
						throw new AssertionError(e);
					} finally {
						executor.shutdown();
					}
				}
			}
		});
		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}

}
