package com.binvi.springboot.demo03.mail;

import com.binvi.springboot.demo03.entity.Message;
import com.binvi.springboot.demo03.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/7/1 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {

	@Autowired
	MailService mailService;
	@Autowired
	TemplateEngine templateEngine;

	private static final String FROM = "1140932775@qq.com";
	private static final String TO = "13752330376@163.com";
	private static final String CC = "413483557@qq.com";

	@Test
	public void sendSimpleMessageTest() {
		String subject = "普通邮件发送测试";
		String content = "来自java程序的普通测试邮件，能收到不？";
		mailService.sendSimpleMail(FROM, TO, CC, subject, content);
	}

	@Test
	public void sendMimeMessageTest() {
		String subject = "带附件的邮件发送测试";
		String content = "来自java程序的带附件的测试邮件，能收到不？";
		File file = new File("G:\\Document\\doc\\个人资料\\韩斌伟简历_2019.pdf");
		mailService.sendAttachFileMail(FROM, TO, CC, subject, content, file);
	}

	@Test
	public void sendMessageWithImageTest() {
		String subject = "带图片的邮件发送测试";
		String content = "<div>来自java程序的带图片的测试邮件，能收到不？"
				+ "（1）一轮明月正在冉冉升起:<div><img src='cid:p01'/></div>"
				+ "（2）我还以为你从来都不会选我呢:<div><img src='cid:p02'/></div>"
				+ "（3）享受荆棘的幽梦吧:<div><img src='cid:p03'/></div>"
				+ "</div>";
		String[] srcPath = {"C:\\Users\\hbw44\\Pictures\\Camera Roll\\1559136533113.jpg",
				"C:\\Users\\hbw44\\Pictures\\Camera Roll\\1559136968921.jpg",
				"C:\\Users\\hbw44\\Pictures\\Camera Roll\\1559137102910.jpg"};
		String[] resIds = {"p01", "p02", "p03"};
		mailService.sendMessageWithImage(FROM, TO, CC, subject, content, srcPath, resIds);
	}

	@Test
	public void sendHtmlMessageWithFreemarkerTemplateTest() {
		String subject = "HTML格式的邮件发送测试（Freemarker模板）";
		try {
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
			ClassLoader classLoader = getClass().getClassLoader();
			configuration.setClassLoaderForTemplateLoading(classLoader, "templates");
			Template template = configuration.getTemplate("mailTemplate.ftl");
			StringWriter writer = new StringWriter();
			Message message = new Message();
			message.setName("Jim Green");
			message.setContent("English");
			template.process(message, writer);
			mailService.sendHtmlMessage(FROM, TO, CC, subject, writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sendHtmlMessageWithThymeleafTemplateTest() {
		String subject = "HTML格式的邮件发送测试（Thymeleaf模板）";
		Context context = new Context();
		context.setVariable("name", "Lily");
		context.setVariable("content", "麻辣小龙虾");
		String mail = templateEngine.process("mailTemplate.html", context);
		mailService.sendHtmlMessage(FROM, TO, CC, subject, mail);
	}

}
