package com.hello.core.beanTest;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AutoAppConfig;

@SpringBootTest
public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = 
			new AnnotationConfigApplicationContext(AutoAppConfig.class);

	@Test
	@DisplayName("모든 빈 출력")
	public void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		Arrays.stream(beanDefinitionNames)
				.map(beanDefinitionName -> "name : " + beanDefinitionName + " object : " + ac.getBean(beanDefinitionName))
				.forEach(System.out::println);
	}
	
	@Test
	@DisplayName("애플리케이션 빈 출력")
	public void findApplicationBean() {

		String[] beanDefinitionNames = ac.getBeanDefinitionNames();

		Arrays.stream(beanDefinitionNames)
			.filter(beanDefinitionName ->
					ac.getBeanDefinition(beanDefinitionName).getRole() == BeanDefinition.ROLE_APPLICATION)
			.map(beanDefinitionName ->
					"name : " + beanDefinitionName + " object : " + ac.getBean(beanDefinitionName))
			.forEach(System.out::println);
		
	}
	
	@Test
	@DisplayName("인프라스트럭쳐 빈 출력")
	public void findInfraStructureBean() {

		String[] beanDefinitionNames = ac.getBeanDefinitionNames();

		Arrays.stream(beanDefinitionNames)
			.filter(beanDefinitionName ->
					ac.getBeanDefinition(beanDefinitionName).getRole() == BeanDefinition.ROLE_INFRASTRUCTURE)
			.map(beanDefinitionName ->
					"name : " + beanDefinitionName + " object : " + ac.getBean(beanDefinitionName))
			.forEach(System.out::println);
		
	}
	
}
