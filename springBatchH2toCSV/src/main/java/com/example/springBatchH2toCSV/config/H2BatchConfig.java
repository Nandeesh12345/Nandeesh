package com.example.springBatchH2toCSV.config;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;



import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


@Configuration
public class H2BatchConfig {

	Logger logger = (Logger) LoggerFactory.getLogger(H2BatchConfig.class);
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	private Resource outputResource = new FileSystemResource("C://Users/nandbj/Downloads/springBatchH2toCSV/output/output.csv");
	
	
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
		logger.info("Setting the datasource for the reader:"+source);
		return source.build();
	}
    
    public JdbcCursorItemReader<Student> reader() {
    	JdbcCursorItemReader<Student> reader=new JdbcCursorItemReader<Student>();
    	reader.setDataSource(getdataSource());
    	reader.setSql("SELECT studentId, studentName, studentAge FROM student");
    	reader.setFetchSize(100);
    	reader.setRowMapper(new RowMapper<Student>(){
		
	
	  
	    @Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentAge(rs.getInt("studentAge"));
			return student;
		}
});
    return reader;	
    }
	@Bean 
	public FlatFileItemWriter<Student> writer(){
		FlatFileItemWriter<Student> writer =new FlatFileItemWriter<Student>();
		writer.setResource(outputResource);
		DelimitedLineAggregator<Student>aggregator=new DelimitedLineAggregator<Student>();
		BeanWrapperFieldExtractor<Student>fieldExtractor=new BeanWrapperFieldExtractor<Student>();
		fieldExtractor.setNames(Student.fields());
		aggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(aggregator);
		return writer;
	}
	
	@Bean
	public Step executeStep() {
		return stepBuilderFactory.get("executeStep").<Student,Student>chunk(10).reader(reader()).processor(processor()).writer(writer()).build();
		
	}
	private StudentProcessor processor() {
		return new StudentProcessor();
	}

	

@Bean
public Job processJob() {
	return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).flow(executeStep()).end().build();
}
	
    }	
	


