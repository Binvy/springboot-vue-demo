package com.binvi.springboot.demo03.book.effectivejava.item50;

import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description: 必要时进行防御性拷贝
 * @date 2019/8/29 21:53
 */
public class Period {

	private final Date start;
	private final Date end;

	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(this.start + " after " + this.end);
		}
	}

	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	@Override
	public String toString() {
		return "Period{" +
				"start=" + start +
				", end=" + end +
				'}';
	}

	public static void main(String[] args) throws InterruptedException {
		Date start = new Date();
		Date end = new Date();

		// 利用参数Date的可变性，进行数据修改
		Period2 period2 = new Period2(start, end);
		System.out.println(period2);
		Thread.sleep(2000);
		System.out.println("利用参数Date的可变性，进行数据修改");
		start.setTime(System.currentTimeMillis());
		System.out.println(period2);

		System.out.println("-------------------------------------");

		// 利用提供的可变参数访问器，进行数据修改
		start = new Date();
		end = new Date();
		Period3 period3 = new Period3(start, end);
		System.out.println(period3);
		Thread.sleep(2000);
		System.out.println("利用参数Date的可变性，进行数据修改");
		start.setTime(System.currentTimeMillis());
		System.out.println(period3);
		Thread.sleep(2000);
		System.out.println("利用提供的可变参数访问器，进行数据修改");
		period3.start().setTime(System.currentTimeMillis());
		System.out.println(period3);

		System.out.println("-------------------------------------");

		start = new Date();
		end = new Date();
		Period period = new Period(start, end);
		System.out.println(period);
		Thread.sleep(2000);
		System.out.println("利用参数Date的可变性，进行数据修改");
		start.setTime(System.currentTimeMillis());
		System.out.println(period);
		Thread.sleep(2000);
		System.out.println("利用提供的可变参数访问器，进行数据修改");
		period.start().setTime(System.currentTimeMillis());
		System.out.println(period);
	}

}

class Period2 {
	private final Date start;
	private final Date end;
	public Period2(Date start, Date end) {
		if (start.after(end)) {
			throw new IllegalArgumentException(start + " after " + end);
		}
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Period2{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}

class Period3 {
	private final Date start;
	private final Date end;
	public Period3(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(this.start + " after " + this.end);
		}
	}
	public Date start() {
		return this.start;
	}
	public Date end() {
		return this.end;
	}

	@Override
	public String toString() {
		return "Period3{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}

