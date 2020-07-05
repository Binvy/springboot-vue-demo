package com.binvi.springboot.demo03.book.effectivejava.item19;

import java.time.Instant;

/**
 * @author binvi
 * @version 1.0
 * @Description: Design and document for inheritance or else prohibit it
 * @date 2019/8/31 10:59
 */
public class Sub extends Super {

	private final Instant instant;

	Sub() {
		instant = Instant.now();
	}

	@Override
	public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}

}
