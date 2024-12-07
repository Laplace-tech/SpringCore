package com.hello.core.beanTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AutoAppConfig;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

@SpringBootTest
public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac 
		= new AnnotationConfigApplicationContext(AutoAppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	public void findBeanByName() {
		MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);
//		System.out.println("memberService : " + memberService);
//		System.out.println("memberService.getClass() : " + memberService.getClass());
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("이름 없이 타입만으로 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByImplName() {
		MemberServiceImpl memberService = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 이름으로 조회X")
	void findBeanByNameX() {
		Assertions.assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxxx", MemberService.class));
	}
}
