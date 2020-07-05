package com.binvi.springboot.demo03.jdk.java.script;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: 脚本引擎相关
 * @date 2019/12/21 12:15
 */
public class ScriptEngineTest {

	private static final ObjectMapper objectmapper = new ObjectMapper();

	/**
	 * @Description:  测试jvm支持的脚本引擎
	 * @author binvi
	 * @date 2019/12/21 12:35
	 * @param []
	 * @return void
	 **/
	@Test
	public void scriptEngineSupportTest() {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		List<ScriptEngineFactory> engineFactories = scriptEngineManager.getEngineFactories();
		if (CollectionUtils.isEmpty(engineFactories)) {
			System.out.println("本JVM不支持任何脚本引擎");
		}
		System.out.println("本JVM支持的脚本引擎个数：" + engineFactories.size());
		System.out.println("本JVM支持的脚本引擎有：");
		engineFactories.forEach(factory -> {
			System.out.println("----------------------------------------------");
			System.out.println("engine name: " + factory.getEngineName());
			System.out.println("engine version: " + factory.getEngineVersion());
			System.out.println("names: " + factory.getNames());
			System.out.println("language name: " + factory.getLanguageName());
			System.out.println("language version: " + factory.getLanguageVersion());
		});

	}

	/**
	 * @Description:  java执行js脚本
	 * @author binvi
	 * @date 2019/12/21 12:35
	 * @param []
	 * @return void
	 **/
	@Test
	public void runJavaScriptTest() throws ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine js = scriptEngineManager.getEngineByName("js");
		js.put("out", System.out);
		String script_js = "for (var i = 0; i < 10; i++) { out.println(i) }";
		System.out.println(js.eval(script_js));
	}

}
