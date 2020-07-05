package com.binvi.springboot.demo03.book.effectivejava.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/4 22:12
 */
public class SetList {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		/**
		 * set.remove(i) 调用重载方法 remove(E)
		 * list.remove(i) 调用重载方法 remove(int i)，从列表的指定位置上去除元素。
		 */
		/*for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove(i);
		}*/

		/**
		 * 解决上面的问题，可以将list.remove的参数转换为Integer
		 */
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove((Integer)i);
		}

		System.out.println(set + " " + list);
	}

}
