package com.binvi.springboot.demo03.jdk.java.lang;

import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/5/19 11:56
 */
public class ThreadLocalTest {

	private ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		return simpleDateFormat;
	});

	@Test
	public void test() {
		SimpleDateFormat format = threadLocal.get();
		Assert.assertNotNull(format);

		threadLocal.remove();
		Assert.assertNotNull(threadLocal.get());

		SimpleDateFormat dateFormat = new SimpleDateFormat();
		threadLocal.set(dateFormat);
		Assert.assertSame(dateFormat, threadLocal.get());
	}

}
