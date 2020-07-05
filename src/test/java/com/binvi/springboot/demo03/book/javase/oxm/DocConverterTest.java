package com.binvi.springboot.demo03.book.javase.oxm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.assimbly.docconverter.DocConverter;
import org.junit.Test;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/30 23:12
 */
public class DocConverterTest {

	@Test
	public void convertXmlToYaml() {
		try {
			String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/file", "test.xml")));
			System.out.println(xml);
			String yaml = DocConverter.convertXmlToYaml(xml);
			System.out.println(yaml);
			// Files.write(Paths.get("src/main/resources/file", "test.yaml"), yaml.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
