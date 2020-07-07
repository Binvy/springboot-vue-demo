package com.binvi.springboot.demo03.book.javase.oxm;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import jdk.internal.org.xml.sax.InputSource;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	/**
	 * 将xml格式的文件转换为yaml格式，转换过程中保留指定节点，删除指定节点。
	 * @param xmlPath xml文件路径
	 * @param yamlPath yaml文件路径
	 * @param keepNodes 保留节点集合，格式为: node1.node2.node3
	 * @param deleteNodes 删除节点集合，格式为：node1.node2.node3
	 */
	public static void filterAndConvert(Path xmlPath, Path yamlPath, List<String> keepNodes, List<String> deleteNodes) {
		try {
			String xml = new String(Files.readAllBytes(xmlPath));
			System.out.println(xml);
			JSONObject jsonObject = XML.toJSONObject(xml);

			jsonObject = filterNodes(jsonObject, keepNodes);
			deleteNodes(jsonObject, deleteNodes);

			String json = jsonObject.toString();
			System.out.println(json);

			JsonNode jsonNode = new ObjectMapper().readTree(json);
			String yaml = new YAMLMapper().writeValueAsString(jsonNode);
			System.out.println(yaml);
			Files.write(yamlPath, yaml.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保留指定key集合的节点元素
	 * @param src
	 * @param exps
	 */
	private static JSONObject filterNodes(JSONObject src, List<String> exps) {
		JSONObject dest = new JSONObject();
		for (String exp : exps) {
			filterNode(src, dest, exp);
		}
		return dest;
	}

	/**
	 * 根据表达式过滤节点
	 * @param src 源对象
	 * @param dest 目标对象
	 * @param exp 节点表达式
	 */
	private static void filterNode(Object src, Object dest, String exp) {
		String[] tags = exp.split("\\.");
		String tag;
		boolean last;
		for (int i = 0; i < tags.length; i++) {
			tag = tags[i];
			last = i == tags.length - 1;
			copyNodeByTag(src, dest, tag, last);
			if (!last) {
				src = getChildNodeByTag(src, tag);
				dest = getChildNodeByTag(dest, tag);
			}
		}
	}

	/**
	 * 获取指定节点下，指定名称的子节点
	 * @param node 节点对象
	 * @param tag 子节点名称
	 * @return 子节点
	 */
	private static Object getChildNodeByTag(Object node, String tag) {
		if (node instanceof JSONObject) {
			return ((JSONObject) node).opt(tag);
		} else if (node instanceof JSONArray) {
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < ((JSONArray) node).length(); i++) {
				jsonArray.put(getChildNodeByTag(((JSONArray) node).get(i), tag));
			}
			return jsonArray;
		}
		return null;
	}

	/**
	 * 根据节点名称复制xml节点
	 * @param src 源节点
	 * @param dest 目标节点
	 * @param tag 节点名称
	 * @param last 是否为最终要保留的节点
	 */
	private static void copyNodeByTag(Object src, Object dest, String tag, boolean last) {
		if (last) {
			if (src instanceof JSONObject) {
				((JSONObject)dest).put(tag, ((JSONObject) src).opt(tag));
			} else if (src instanceof JSONArray) {
				for (int i = 0; i < ((JSONArray) src).length(); i++) {
					copyNodeByTag(((JSONArray) src).opt(i), ((JSONArray) dest).opt(i), tag, last);
				}
			}
		} else {
			if (src instanceof JSONObject) {
				Object copySource = ((JSONObject) src).opt(tag);
				Object copyTarget = ((JSONObject) dest).opt(tag);
				if (copySource instanceof JSONObject) {
					if (((JSONObject) dest).isNull(tag)) {
						((JSONObject) dest).accumulate(tag, new JSONObject());
					}
				} else if (copySource instanceof JSONArray) {
					int copyLength = 0;
					if (copyTarget == null) {
						copyLength = ((JSONArray) copySource).length();
					} else if (copyTarget instanceof JSONObject) {
						copyLength = ((JSONArray) copySource).length() - 1;
					} else if (copyTarget instanceof JSONArray) {
						copyLength = ((JSONArray) copySource).length() - ((JSONArray) copyTarget).length();
					}
					for (int i = 0; i < copyLength; i++) {
						((JSONObject) dest).accumulate(tag, new JSONObject());
					}
				}
			} else if (src instanceof JSONArray) {
				for (int i = 0; i < ((JSONArray) src).length(); i++) {
					copyNodeByTag(((JSONArray) src).get(i), ((JSONArray) dest).get(i), tag, last);
				}
			}
		}
	}


	/**
	 * 删除指定key集合的节点元素，元素key格式为"node1.node2.node3"如:
	 *     MediaItem.Images
	 *     MediaItem.Images.name
	 * @param jsonObject
	 * @param exps
	 */
	private static void deleteNodes(JSONObject jsonObject, List<String> exps) {
		Collections.sort(exps, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.indexOf(".") - o2.indexOf(".");
			}
		});
		for (String realKey : exps) {
			deleteNode(jsonObject, realKey);
		}
	}

	/**
	 * 根据指定节点下与表达式匹配的子节点
	 * @param node 节点
	 * @param exp 子节点表达式
	 */
	private static void deleteNode(Object node, String exp) {
		if (node == null || StringUtils.isEmpty(exp) ) {
			return;
		}
		if (exp.indexOf(".") == -1) {
			if (node instanceof JSONObject) {
				((JSONObject) node).remove(exp);
			} else if (node instanceof JSONArray) {
				for (Object object : ((JSONArray) node)) {
					deleteNode(object, exp);
				}
			}
		} else {
			String currentKey = exp.substring(0, exp.indexOf("."));
			String remainKey = exp.substring(exp.indexOf(".") + 1);
			if (node instanceof JSONObject) {
				deleteNode(((JSONObject) node).get(currentKey), remainKey);
			} else if (node instanceof JSONArray) {
				for (Object object : ((JSONArray) node)) {
					if (object instanceof JSONObject) {
						deleteNode(((JSONObject) object).get(currentKey), remainKey);
					} else if (object instanceof JSONArray) {
						deleteNode(object, exp);
					}
				}
			}
		}
	}

}
