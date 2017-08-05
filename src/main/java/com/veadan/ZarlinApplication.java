package com.veadan;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
@ComponentScan("com.veadan.*")
@MapperScan(basePackages = {"com.veadan.recManage.recDao","com.veadan.userManage.userDao"})//扫描该包下的相应的class主要是mybatis的持久化类
public class ZarlinApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

//注入Bean : HttpMessageConverters

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZarlinApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ZarlinApplication.class, args);
	}




}




/*@SpringBootApplication
@ComponentScan("com.veadan.*")
@MapperScan(basePackages = {"com.veadan.recManage.dao.userModel","com.veadan.recManage.dao.recModel","com.veadan.recManage.dao"})//扫描该包下的相应的class主要是mybatis的持久化类
public class ZkpdaApplication extends SpringBootServletInitializer {

//注入Bean : HttpMessageConverters

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZkpdaApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ZkpdaApplication.class, args);
	}




}*/
