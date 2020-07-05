package com.binvi.springboot.demo03.validator.referenceguide.chapter03.model;

import lombok.Data;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Pattern;

/**
 * @author binvi
 * @version 1.0
 * @Description: Hibernate validator条件必输 Demo请求类
 * @date 2019/12/19 21:52
 */
@ScriptAssert.List({
		@ScriptAssert(lang = "javascript", script = "_this.type != 00 || !!_this.flag", message = "type为00时，flag不能为空"),
		@ScriptAssert(lang = "javascript", script = "_this.type != 00 || !!_this.flag2", message = "type为00时，flag2不能为空"),
		@ScriptAssert(lang = "javascript", script = "_this.type != 00 || !!_this.flag3", message = "type为00时，flag3不能为空"),
		@ScriptAssert(lang = "javascript", script = "_this.type != 00 || !!_this.flag4", message = "type为00时，flag4不能为空")
})
@Data
public class DemoRequest {

	private String id;
	private String name;
	@Pattern(regexp = "00|01|02|03|04|05")
	private String type;
	private String flag;
	private String flag2;
	private String flag3;
	@Pattern(regexp = "11|12|13|14|15", message = "flag4必须在[{regexp}]之间取值")
	private String flag4;

}
