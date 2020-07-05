package com.binvi.springboot.demo03.book.javase.oxm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import jdk.internal.org.xml.sax.InputSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/29 22:11
 */
public class XmlToYamlConverter {

	private static final Logger logger = LoggerFactory.getLogger(XmlToYamlConverter.class);

	private static final XmlMapper xmlMapper = new XmlMapper();
	private static final YAMLMapper yamlMapper = new YAMLMapper();

	private static String oxmDir = "src/main/resources/file";
	private static String xmlFile = "test.xml";
	private static String yamlFile = "test.yaml";

	Path xmlPath = Paths.get(oxmDir, xmlFile);
	Path yamlPath = Paths.get(oxmDir, yamlFile);

	public void convertBeanToXml() {
		try (BufferedWriter writer = Files.newBufferedWriter(xmlPath)) {
			MediaItem tempRecord = MediaItem.getTempRecord();
			xmlMapper.writeValue(writer, tempRecord);
			List<String> xmlLines = Files.readAllLines(xmlPath);
			logger.info("convert bean to xml end. result xml: {}", xmlLines);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void convertXmlToBean() {
		try (BufferedReader reader = Files.newBufferedReader(xmlPath)) {
			MediaItem mediaItem = xmlMapper.readValue(reader, MediaItem.class);
			logger.info("convert xml to bean end. result bean: {}", mediaItem);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void convertBeanToYaml() {
		try (BufferedWriter writer = Files.newBufferedWriter(yamlPath)) {
			yamlMapper.writeValue(writer, MediaItem.getTempRecord());
			List<String> yamlLines = Files.readAllLines(yamlPath);
			logger.info("convert bean to yaml end. result yaml: {}", yamlLines);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void convertYamlToBean() {
		try (BufferedReader reader = Files.newBufferedReader(yamlPath)) {
			MediaItem mediaItem = yamlMapper.readValue(reader, MediaItem.class);
			logger.info("convert yaml to bean end. result bean: {}", mediaItem);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void convertXmlToYaml() {
		try (BufferedReader xmlReader = Files.newBufferedReader(xmlPath);
			 BufferedWriter yamlWriter = Files.newBufferedWriter(yamlPath)) {
			logger.info("read json from xml start. xml: {}", Files.readAllLines(xmlPath));
			Object json = xmlMapper.readValue(xmlReader, Object.class);
			yamlMapper.writeValue(yamlWriter, json);
			logger.info("write json to yaml end. yaml: {}", Files.readAllLines(yamlPath));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void convertYamlToXml() {
		try (BufferedReader yamlReader = Files.newBufferedReader(yamlPath);
			 BufferedWriter xmlWriter = Files.newBufferedWriter(xmlPath)) {
			logger.info("read json from yaml start. yaml: {}", Files.readAllLines(yamlPath));
			Object json = yamlMapper.readValue(yamlReader, Object.class);
			xmlMapper.writeValue(xmlWriter, json);
			logger.info("write json to yaml end. yaml: {}", Files.readAllLines(xmlPath));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public String findNode(String expression) {
		String result = null;
		try (InputStream inputStream = Files.newInputStream(xmlPath)) {
			InputSource inputSource = new InputSource(inputStream);
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			result = xPath.evaluate(expression, inputSource);
		} catch (IOException | XPathExpressionException e) {
			e.printStackTrace();
		}
		return result;
	}

}
