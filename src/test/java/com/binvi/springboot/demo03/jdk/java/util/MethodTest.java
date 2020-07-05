package com.binvi.springboot.demo03.jdk.java.util;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/7/28 14:56
 */
public class MethodTest {

	private void test() {
		Method[] methods = getClass().getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("==================================");
			System.out.println("方法名称：" + method.getName());
			Class<?>[] parameterTypes = method.getParameterTypes();
			Annotation[][] annotationss = method.getParameterAnnotations();
			Iterator<Annotation[]> iterator = Arrays.asList(annotationss).iterator();
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("-------------------------------");
				System.out.println("参数名称：" + parameterType.getName());
				System.out.println(parameterType.getSimpleName());
				Annotation[] annotations = iterator.next();
				for (Annotation annotation : annotations) {
					System.out.println("参数注解：" + annotation.annotationType().getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		new MethodTest().test();
	}

	String id;
	String name;

	public void init(@NotNull String id, @NotBlank @Length(min = 10, max = 20)String name) {
		this.id = id;
		this.name = name;
	}
}
