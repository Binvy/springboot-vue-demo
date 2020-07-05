package com.binvi.springboot.demo03.book.effectivejava.item52;

import java.util.Arrays;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: 选择被覆盖的方法的正确版本是在运行时进行的，选择的依据是被调用的方法所在对象的运行时类型。
 * @date 2019/9/4 22:00
 */
class Wine {
	String name() { return "wine"; }
}

class SparklingWine extends Wine {
	@Override
	String name() {
		return "sparkling wine";
	}
}

class Champagne extends SparklingWine {
	@Override
	String name() {
		return "champagne";
	}
}

public class Overriding {
	public static void main(String[] args) {
		List<Wine> wines = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
		for (Wine wine : wines) {
			System.out.println(wine.name());
		}
	}
}
