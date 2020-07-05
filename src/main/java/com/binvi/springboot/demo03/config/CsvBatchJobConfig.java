package com.binvi.springboot.demo03.config;

import com.binvi.springboot.demo03.entity.Anime;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @author binvi
 * @version 1.0
 * @Description: CSV批处理配置
 * @date 2019/7/3 18:47
 */
@Configuration
public class CsvBatchJobConfig {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	@Autowired
	DataSource dataSource;

	@Bean
	@StepScope
	FlatFileItemReader itemReader() {
		FlatFileItemReader<Anime> reader = new FlatFileItemReader<>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("file\\anime.csv"));
		reader.setLineMapper(new DefaultLineMapper<Anime>(){{
			setLineTokenizer(new DelimitedLineTokenizer(){{
				setNames("id", "author", "description", "name", "price", "publish_date", "remark", "star");
				setDelimiter(",");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Anime>(){{
				setTargetType(Anime.class);
			}});
		}});
		return reader;
	}

	@Bean
	JdbcBatchItemWriter jdbcBatchItemWriter() {
		JdbcBatchItemWriter writer = new JdbcBatchItemWriter();
		writer.setDataSource(dataSource);
		writer.setSql("insert into anime " +
				"(id, author, description, name, price, publish_date, remark, star)" +
				"values " +
				"(:id, :author, :description, :name, :price, :publishDate, :remark, :star)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
		return writer;
	}

	@Bean
	Step csvStep() {
		return stepBuilderFactory.get("csvStep")
				.<Anime, Anime>chunk(2)
				.reader(itemReader())
				.writer(jdbcBatchItemWriter())
				.build();
	}

	@Bean
	Job csvJob() {
		return jobBuilderFactory.get("csvJob")
				.start(csvStep())
				.build();
	}

}