package com.binvi.springboot.demo03.book.effectivejava.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author binvi
 * @version 1.0
 * @Description: 谨慎使用Stream
 * @date 2019/9/3 22:41
 */
public class Anagrams {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);
		try (Stream<String> words = Files.lines(path)) {
			words.collect(groupingBy(word -> alphabetize(word)))
					.values().stream()
					.filter(group -> group.size() >= minGroupSize)
					.forEach(g -> System.out.println(g.size() + " : " + g));
		}
	}

	private static String alphabetize(String word) {
		char[] a = word.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
