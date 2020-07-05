package com.binvi.springboot.demo03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author binvi
 * @version 1.0
 * @Description: 发送邮件
 * @date 2019/7/1 21:34
 */
@Component
public class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	@Autowired
	JavaMailSender javaMailSender;

	/**
	 * 发送普通邮件
	 * @param from
	 * @param to
	 * @param cc
	 * @param subject
	 * @param content
	 */
	public void sendSimpleMail(String from,
							   String to,
							   String cc,
							   String subject,
							   String content) {
		logger.info("发送普通邮件开始");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setCc(cc);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
		logger.info("发送普通邮件完成");
	}

	/**
	 * 发送带附件的邮件
	 * @param from
	 * @param to
	 * @param cc
	 * @param subject
	 * @param content
	 * @param file
	 */
	public void sendAttachFileMail(String from,
								   String to,
								   String cc,
								   String subject,
								   String content,
								   File file) {
		logger.info("发送带附件的邮件开始");
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setCc(cc);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content);
			mimeMessageHelper.addAttachment(file.getName(), file);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			logger.error("发送带附件的邮件异常", e);
			e.printStackTrace();
		}
		logger.info("发送带附件的邮件完成");
	}

	/**
	 * 发送带图片的邮件
	 * @param from
	 * @param to
	 * @param cc
	 * @param subject
	 * @param content
	 * @param srcPath
	 * @param resIds
	 */
	public void sendMessageWithImage(String from,
									 String to,
									 String cc,
									 String subject,
									 String content,
									 String[] srcPath,
									 String[] resIds) {
		logger.info("发送带图片的邮件开始");
		if (srcPath == null || srcPath.length == 0
				|| resIds == null || resIds.length == 0
				|| srcPath.length != resIds.length) {
			logger.info("图片信息不对应，请确认正确后重新发送");
			return;
		}
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(content, true);
			for (int i = 0; i < srcPath.length; i++) {
				FileSystemResource resource = new FileSystemResource(srcPath[i]);
				helper.addInline(resIds[i], resource);
			}
			javaMailSender.send(message);
		} catch (MessagingException e) {
			logger.error("发送带图片的邮件异常", e);
			e.printStackTrace();
		}
		logger.info("发送带图片的邮件完成");
	}

	public void sendHtmlMessage(String from,
								String to,
								String cc,
								String subejct,
								String content) {
		logger.info("发送HTML格式的邮件开始");
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subejct);
			helper.setText(content, true);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			logger.info("发送HTML格式的邮件异常");
			e.printStackTrace();
		}
		logger.info("发送HTML格式的邮件完成");
	}

}
