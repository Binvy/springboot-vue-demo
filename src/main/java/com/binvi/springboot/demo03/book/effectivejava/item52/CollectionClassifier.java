package com.binvi.springboot.demo03.book.effectivejava.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: 慎用重载
 *     1. 对于重载方法的选择是静态的
 *     2. 对于覆盖方法的选择是动态的
 * @date 2019/9/4 21:54
 */
public class CollectionClassifier {

	public static String classify(Set<?> s) {
		return "Set";
	}

	public static String classify(List<?> l) {
		return "List";
	}

	public static String classify(Collection<?> c) {
		return "Unknown Collection";
	}

	/**
	 * 要选择哪个重载方法是在编译时做出决定的。
	 * 	   三次迭代，参数的编译时类型是相同的，都是Collection<?>
	 * 	   三次迭代，参数的运行时类型是不同的，但并不影响重载方法的选择。
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<?>[] collection = {
			new HashSet<String>(),
				new ArrayList<BigInteger>(),
				new HashMap<String, String>().values()
		};
		for (Collection<?> c : collection) {
			System.out.println(classify(c));
		}
	}

}
