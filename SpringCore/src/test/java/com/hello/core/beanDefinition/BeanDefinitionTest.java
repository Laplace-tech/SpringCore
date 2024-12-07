package com.hello.core.beanDefinition;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


@SpringBootTest
public class BeanDefinitionTest {

//	AnnotationConfigApplicationContext ac 
//		= new AnnotationConfigApplicationContext(AppConfig.class);
	
	GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
	
	@Test
	@DisplayName("빈 설정 메타정보 확인")
	public void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		Function<String, String> function = beanDefinitionName 
				-> "beanDefinitionName : " + beanDefinitionName
				+ " beanDefinition : " + ac.getBeanDefinition(beanDefinitionName);
		Predicate<String> roleApplication = beanDefinitionName 
				-> ac.getBeanDefinition(beanDefinitionName).getRole() 
				== BeanDefinition.ROLE_APPLICATION;
	
		Arrays.stream(beanDefinitionNames)
			.filter(roleApplication)
			.map(function)
			.forEach(System.out::println);
	}
	
	
}
