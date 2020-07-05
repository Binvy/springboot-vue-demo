package com.binvi.springboot.demo03.book.jvm.chapter8;

/**
 * @author binvi
 * @version 1.0
 * @Description: 单分派和多分派演示
 * @date 2019/9/19 21:45
 */
public class Dispatch {

	static class QQ {}

	static class _360 {}

	public static class Father {
		public void hardChoice(QQ arg) {
			System.out.println("father choose QQ");
		}

		public void hardChoice(_360 arg) {
			System.out.println("father choose 360");
		}
	}

	public static class Son extends Father {
		public void hardChoice(QQ arg) {
			System.out.println("son choose QQ");
		}

		public void hardChoice(_360 arg) {
			System.out.println("son choose 360");
		}
	}

	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}

}
