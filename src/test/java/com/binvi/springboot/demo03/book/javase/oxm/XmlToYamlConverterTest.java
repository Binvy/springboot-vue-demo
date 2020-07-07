package com.binvi.springboot.demo03.book.javase.oxm;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlToYamlConverterTest {

	private XmlToYamlConverter converter = new XmlToYamlConverter();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void convertBeanToXml() {
		converter.convertBeanToXml();
	}

	@Test
	public void convertXmlToBean() {
		converter.convertXmlToBean();
	}

	@Test
	public void convertBeanToYaml() {
		converter.convertBeanToYaml();
	}

	@Test
	public void convertYamlToBean() {
		converter.convertYamlToBean();
	}

	@Test
	public void convertXmlToYaml() {
		converter.convertXmlToYaml();
	}

	@Test
	public void convertYamlToXml() {
		converter.convertYamlToXml();
	}

	private static String oxmDir = "src/main/resources/file";
	private static String xmlFile = "test.xml";
	private static String yamlFile = "test.yaml";

	Path xmlPath = Paths.get(oxmDir, xmlFile);
	Path yamlPath = Paths.get(oxmDir, yamlFile);

	List<String> keepNodes = Arrays.asList("MediaItem.id",
			"MediaItem.Content.id", "MediaItem.Content.name", "MediaItem.Content.class",
			"MediaItem.Images.id", "MediaItem.Images.name", "MediaItem.Images.Size");

	List<String> deleteNodes = Arrays.asList(
			"MediaItem.id",
			"MediaItem.Images.Size");

	@Test
	public void filterAndConvert() {
		XmlToYamlConverter.filterAndConvert(xmlPath, yamlPath, keepNodes, deleteNodes);
	}

	@Test
	public void testFindNode() {
		String expression = "MediaItem/Content/Copyright";
		String result = converter.findNode(expression);
		Assert.assertEquals(result, "None");
	}

	/**
	 * 保留指定key集合的节点元素
	 * @param src
	 * @param exps
	 */
	private JSONObject filterNodes(JSONObject src, List<String> exps) {
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
	private void filterNode(Object src, Object dest, String exp) {
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
	private Object getChildNodeByTag(Object node, String tag) {
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
	private void copyNodeByTag(Object src, Object dest, String tag, boolean last) {
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
	private void deleteNodes(JSONObject jsonObject, List<String> exps) {
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

	private void deleteNode(Object node, String exp) {
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