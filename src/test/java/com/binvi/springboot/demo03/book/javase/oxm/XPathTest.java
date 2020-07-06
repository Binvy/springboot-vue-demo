package com.binvi.springboot.demo03.book.javase.oxm;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/7/6 22:42
 */
public class XPathTest {

	private String oxmDir = "src/test/resources/file/oxm";
	private String xmlFile = "configuration.xml";
	private Path xmlPath = Paths.get(oxmDir, xmlFile);

	@Test
	public void test() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlPath.toFile());
			XPathFactory xpFactory = XPathFactory.newInstance();
			XPath path = xpFactory.newXPath();

			String expression = "/configuration/database/username";
			String username = path.evaluate(expression, doc);

			NodeList nodes = (NodeList) path.evaluate("gridbag/row", doc, XPathConstants.NODESET);
			Node node = (Node) path.evaluate("gridbag/row[1]", doc, XPathConstants.NODE);
			node.getParentNode().getChildNodes();

			int count = ((Number) path.evaluate("count(gridbag/row)", doc, XPathConstants.NUMBER)).intValue();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}


	}

}
