package com.binvi.springboot.demo03.jdk.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description: Test about ArrayList
 * @date 2019/10/30 20:18
 */
public class ArrayListTest {

	private static final Logger log = LoggerFactory.getLogger(ArrayListTest.class);

	public static void main(String[] args) {
		toArrayTest();
	}

	private static void toArrayTest() {

		ArrayList<String> arrayWithDefaultCapacity = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			arrayWithDefaultCapacity.add(String.valueOf(i));
		}
		log.info("arrayWithDefaultCapacity:{}", arrayWithDefaultCapacity);


		int size = 5;
		ArrayList<String> arrayWithDefinedCapacity = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			arrayWithDefinedCapacity.add(String.valueOf(i));
		}
		log.info("arrayWithDefinedCapacity:{}", arrayWithDefinedCapacity);

		String[] stringShortLength = new String[1];
		stringShortLength[0] = "hello";
		String[] stringsTransferFromShortArray = arrayWithDefaultCapacity.toArray(stringShortLength);
		log.info("stringsTransferFromShortArray:{}", Arrays.toString(stringsTransferFromShortArray));

		int length = 20;
		String[] stringLargeLength = new String[length];
		for (int i = 0; i < length; i++) {
			stringLargeLength[i] = String.valueOf(i);
		}
		String[] stringsTransferFromLargeArray = arrayWithDefaultCapacity.toArray(stringLargeLength);
		log.info("stringsTransferFromLargeArray:{}", Arrays.toString(stringsTransferFromLargeArray));
	}


}
