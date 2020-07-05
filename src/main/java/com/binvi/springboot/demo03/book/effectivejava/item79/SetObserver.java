package com.binvi.springboot.demo03.book.effectivejava.item79;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/8 10:33
 */
@FunctionalInterface
public interface SetObserver<E> {

	void added(ObservableSet<E> set, E element);

}
