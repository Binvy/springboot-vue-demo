package com.binvi.springboot.demo03.book.jvm.chapter10;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/22 10:46
 */
public class IntegerTest {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	/**
	 * 自动装箱的陷阱
	 */
	private static void test1() {
		System.out.println("--------------------test1--------------------");
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d); 			// true
		System.out.println(e == f); 			// false
		System.out.println(c == (a + b)); 		// true
		System.out.println(c.equals(a + b));	// true
		System.out.println(g == (a + b)); 		// true (等价于g == (long)(a + b))
		System.out.println(g.equals(a + b)); 	// false
	}

	private static void test2() {
		System.out.println("--------------------test2--------------------");
		Integer a = new Integer(89);
		Integer b = new Integer(89);
		System.out.println(a == b); 		// false
		System.out.println(a.equals(b)); 	// true

		Integer c = new Integer(197);
		Integer d = new Integer(197);
		System.out.println(c == d);			// false
		System.out.println(c.equals(d));	// true

		Integer e = 127;
		Integer f = 127;
		System.out.println(e == f);			// true
		System.out.println(e.equals(f));	// true

		Integer g = 128;
		Integer h = 128;
		System.out.println(g == h);			// false
		System.out.println(g.equals(h));	// true
	}

	private static void test3(){
		System.out.println("--------------------test3--------------------");
		Integer a = 59;
		int b = 59;
		Integer c = Integer.valueOf(59);
		Integer d = new Integer(59);
		System.out.println(a == b);			// true
		System.out.println(a == c);			// true
		System.out.println(c == d);			// false
		System.out.println(b == d);			// true
	}

}
