package com.binvi.springboot.demo03.book.jvm.chapter3;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/13 10:33
 */
public class gcTest {

	private static final int MB = 1024 * 1024;

	public static void main(String[] args) {
		// testAllocation();
		// testPretenureSizeThreshold();
		// testTenuringThreshold();
		// testTenuringThreshold2();
		testHandlePromotion();
	}

	/**
	 * 对象优先在Eden分配：
	 *     运行参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	private static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * MB];
		allocation2 = new byte[2 * MB];
		allocation3 = new byte[2 * MB];
		allocation4 = new byte[4 * MB];
	}

	/**
	 * 大对象直接进入老年代：
	 *     运行参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 */
	private static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * MB];
	}

	/**
	 * 长期存活的对象将进入老年代：
	 *     运行参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:PrintTenuringDistribution
	 *               -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PrintTenuringDistribution
	 */
	private static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[MB / 4];
		allocation2 = new byte[4 * MB];
		allocation3 = new byte[4 * MB];
		allocation3 = null;
		allocation3 = new byte[4 * MB];
	}

	/**
	 * 动态对象年龄判断：
	 *     运行参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PrintTenuringDistribution
	 */
	private static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[MB / 4];
		allocation2 = new byte[MB / 4];
		allocation3 = new byte[4 * MB];
		allocation4 = new byte[4 * MB];
		allocation4 = null;
		allocation4 = new byte[4 * MB];
	}

	/**
	 * 空间分配担保：
	 *     运行参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
	 * -XX:-HandlePromotionFailure jdk1.8不识别
	 */
	private static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * MB];
		allocation2 = new byte[2 * MB];
		allocation3 = new byte[2 * MB];
		allocation1 = null;
		allocation4 = new byte[2 * MB];
		allocation5 = new byte[2 * MB];
		allocation6 = new byte[2 * MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * MB];
	}

}
