package com.example.springBatchChunkListener.config;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	 @Value("classpath:input.csv")
	  private Resource inputResource;
	
	 
	@Bean
	public Job readCSVFilesJob() {
		return jobBuilderFactory.get("readCSVFilesJob").flow(step1()).end().build();
	}
	@Bean
	public Step step1() {
	  return stepBuilderFactory
	      .get("step1")
	      .<Employee, Employee>chunk(10)
	      .reader(reader()).processor(processor())
	      .writer(writer())
	      .build();
	}
	 
	@Bean
	public Processor processor() {
	  return new Processor();
	}
	
	@Bean
	  public FlatFileItemReader<Employee> reader() {
	    FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<Employee>();
	    itemReader.setLineMapper(lineMapper());
	    itemReader.setLinesToSkip(1);
	    itemReader.setResource(new FileSystemResource("src/main/resources/input.csv"));
	    System.out.println("itemReader:"+itemReader);
	    return itemReader;
	    
	    }
	 
	  @Bean
	  public LineMapper<Employee> lineMapper() {
	    DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(Employee.fields());
	    BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
	    fieldSetMapper.setTargetType(Employee.class);
	    fieldSetMapper.setStrict(false);
	    lineMapper.setLineTokenizer(lineTokenizer);
	    lineMapper.setFieldSetMapper(fieldSetMapper);
	    return lineMapper;
	  }

		
		
		
		/*
		 * @Bean public ConsoleItemWriter<Employee> writer() { return new
		 * ConsoleItemWriter(); }
		 */
		 
       @Bean public JdbcBatchItemWriter<Employee> writer() {
		  
		  JdbcBatchItemWriter<Employee> itemWriter = new
		  JdbcBatchItemWriter<Employee>();
		  System.out.println("itemWriter:"+itemWriter);
		  itemWriter.setDataSource(getdataSource());
		 
		  itemWriter.setSql("insert into employee (id, firstName, lastName) values (:id, :firstName, :lastName)"); 
		  itemWriter.setItemSqlParameterSourceProvider(new
		  BeanPropertyItemSqlParameterSourceProvider<Employee>());
		  itemWriter.afterPropertiesSet();
		  
		  
		  itemWriter.setItemSqlParameterSourceProvider(new
		  BeanPropertyItemSqlParameterSourceProvider<Employee>());
		  
		  return itemWriter;
		  
		  
		  }
		 
       
       @Value(value="${spring.datasource.url}")
		String url;
       @Value(value="${spring.datasource.driverClassName}")
       String className;
       @Value(value="${spring.datasource.username}")
       String userName;
		 
		private DataSource getdataSource() {
			@SuppressWarnings("rawtypes")
			DataSourceBuilder source= DataSourceBuilder.create();
			
			
			source.url(url);
			source.driverClassName(className);
			source.username(userName);
			source.password("");
			System.out.println("source:"+source);
			return source.build();
		}
		
	
	}
	

