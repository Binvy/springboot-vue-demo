package com.binvi.springboot.demo03.config;

import com.binvi.springboot.demo03.component.MyQuartzJobTwo;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: Quartz定时配置类
 * @date 2019/7/2 23:15
 */
@Configuration
public class QuartzConfig {

	@Bean
	MethodInvokingJobDetailFactoryBean jobDetailOne() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetBeanName("myQuartzJobOne");
		bean.setTargetMethod("sayHello");
		return bean;
	}

	@Bean
	JobDetailFactoryBean jobDetailTwo() {
		JobDetailFactoryBean bean = new JobDetailFactoryBean();
		bean.setJobClass(MyQuartzJobTwo.class);
		JobDataMap dataMap = new JobDataMap();
		dataMap.put("name", "lily");
		bean.setJobDataMap(dataMap);
		bean.setDurability(true);
		return bean;
	}

	@Bean
	SimpleTriggerFactoryBean simpleTrigger() {
		SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
		bean.setJobDetail(jobDetailOne().getObject());
		bean.setRepeatCount(5);
		bean.setStartDelay(10000);
		bean.setRepeatInterval(60000);
		return bean;
	}

	@Bean
	CronTriggerFactoryBean cronTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(jobDetailTwo().getObject());
		bean.setCronExpression("0 0/1 * * * ?");
		return bean;
	}

	@Bean
	SchedulerFactoryBean scheduler() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		SimpleTrigger simpleTrigger = simpleTrigger().getObject();
		CronTrigger cronTrigger = cronTrigger().getObject();
		bean.setTriggers(simpleTrigger, cronTrigger);
		return bean;
	}

}
