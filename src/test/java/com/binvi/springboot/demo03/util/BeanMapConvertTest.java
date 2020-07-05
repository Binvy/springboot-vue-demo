package com.binvi.springboot.demo03.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binvi.springboot.demo03.model.NoteBook;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: bean map相互转换的相关测试
 * @date 2019/12/23 23:32
 */
public class BeanMapConvertTest {

	public static final int SIZE_1 = 1;
	public static final int SIZE_2 = 10;
	public static final int SIZE_3 = 100;
	public static final int SIZE_4 = 1000;
	public static final int SIZE_5 = 10000;
	public static final int SIZE_6 = 100000;
	public static final int SIZE_7 = 1000000;
	public static final int SIZE_8 = 10000000;
	public static final int SIZE_9 = 100000000;

	/**
	 * @Description: Straight up Java
	 * @author binvi
	 * @date 2019/12/23 23:50
	 **/
	@Test
	public void convert_object_to_map_java() throws IntrospectionException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {

		// bean -> map
		NoteBook notebook = new NoteBook(100, "Action Method Notebook");
		Map<String, Object> objectAsMap = new HashMap<>();
		BeanInfo info = Introspector.getBeanInfo(notebook.getClass());
		PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : propertyDescriptors) {
			Method reader = pd.getReadMethod();
			if (reader != null)
				objectAsMap.put(pd.getName(),reader.invoke(notebook));
		}

		// map -> bean
		NoteBook book = new NoteBook();
		Map<String, Object> map = Maps.newHashMap();
		map.put("numberOfSheets", "1000");
		map.put("description", "desc");
		for (PropertyDescriptor pd : propertyDescriptors) {
			Method writer = pd.getWriteMethod();
			if (writer != null) {
				String name = pd.getName();
				Class<?>[] parameterTypes = writer.getParameterTypes();
				if (map.containsKey(name)) {
					writer.invoke(book, map.get(name)); // 此处需要进行参数类型判断并转换。所以，最好是全部String类型较为方便。
				}
			}
		}
	}

	/**
	 * @Description: Apache Commons
	 * @author binvi
	 * @date 2019/12/23 23:51
	 **/
	@Test
	public void convert_object_to_map_apache_commons () throws Exception {

		// bean -> map
		NoteBook fieldNoteBook = new NoteBook(878, "Field Notebook");
		// 第一种：仅限于Map<String, String>
		@SuppressWarnings("unchecked")
		/*Map<String, String> map = BeanUtils.describe(fieldNoteBook);*/

		// 同级非公开类存在问题，生成map为空（原因：非public类读写方法不开放，导致反射异常）
		/*Demo demo = new Demo();
		demo.setId("id");
		demo.setName("name");
		Map<String, String> demoMap = BeanUtils.describe(demo);*/

		// 第二种：
		Map beanMap = new BeanMap(fieldNoteBook);

		// map -> bean 必须先新建实体类实例
		Map<String, String> map = Maps.newHashMap();
		map.put("numberOfSheets", "123");
		map.put("description", "desc");
		BeanUtils.populate(fieldNoteBook, map);

	}

	/**
	 * @Description: Jackson
	 * @author binvi
	 * @date 2019/12/23 23:50
	 **/
	@Test
	public void convert_object_to_map_jackson() {

		ObjectMapper objectmapper = new ObjectMapper();
		Map<String, Object> map = Maps.newHashMap();
		map.put("numberOfSheets", "123");
		map.put("description", "desc");
		NoteBook demo = null;
		// map -> bean
		demo = objectmapper.convertValue(map, NoteBook.class);
		// demo = objectmapper.convertValue(map, objectmapper.getTypeFactory().constructType(NoteBook.class));
		// demo = objectmapper.convertValue(map, new TypeReference<NoteBook>(){});
		// bean -> map
		// map = objectmapper.convertValue(demo, map.getClass());
		// map = objectmapper.convertValue(demo, objectmapper.getTypeFactory().constructType(Map.class));
		// Note that it is better to use TypeReference instead of a direct class in this case as the second argument to convertValue().
		// This way we have a checked assignment to correctly typed map instead of Map.
		map = objectmapper.convertValue(map, new TypeReference<Map<String, Object>>(){});

	}

	@Test
	public void convert_object_to_map_fastjson() {

		// map -> bean
		Map<String, Object> map = Maps.newHashMap();
		map.put("numberOfSheets", "123");
		map.put("description", "desc");
		JSONObject jsonObject = new JSONObject(map);
		NoteBook notebook = jsonObject.toJavaObject(NoteBook.class);

		// bean -> map
		map = null;
		String json = JSON.toJSONString(notebook);
		map = JSON.parseObject(json, Map.class);

	}

	@Test
	public void speedTest() throws Exception {
		BeanMapConvertTest test = new BeanMapConvertTest();
		test.run(SIZE_1);
		test.run(SIZE_2);
		test.run(SIZE_3);
		test.run(SIZE_4);
		test.run(SIZE_5);
		test.run(SIZE_6);
		test.run(SIZE_7);
		test.run(SIZE_8);
		test.run(SIZE_9);
	}

	public void run(int time) throws Exception {
		System.out.println("---------------------------------------" + time);

		BeanMapConvertTest test = new BeanMapConvertTest();

		long start1 = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			test.convert_object_to_map_apache_commons();
		}
		long end1 = System.currentTimeMillis();
		System.out.println("apache cost : " + (end1 - start1));

		long start2 = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			test.convert_object_to_map_jackson();
		}
		long end2 = System.currentTimeMillis();
		System.out.println("jackson cost : " + (end2 - start2));

		long start3 = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			test.convert_object_to_map_fastjson();
		}
		long end3 = System.currentTimeMillis();
		System.out.println("fastjson cost : " + (end3 - start3));
		System.out.println();
	}

}

@Data
class Demo {
	private String id;
	private String name;
}