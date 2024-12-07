package com.hello.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;

public class MemberServiceTest {

	MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		memberService = ac.getBean(MemberService.class);
	}
	
	@Test 
	void join() {
		//given
		Member member = new Member(1L, "G-DRAGON", Grade.VIP);
		
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
	
}
