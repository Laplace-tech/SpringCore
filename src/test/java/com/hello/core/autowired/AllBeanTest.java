package com.hello.core.autowired;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AutoAppConfig;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class AllBeanTest {

	@Test
	public void findAllBean() {
		
		// 지정된 구성 클래스(AutoAppConfig 및 DiscountService)를 읽어서, Spring 컨테이너에 빈을 등록합니다.
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

		DiscountService discountService = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "userA", Grade.VIP);
		
		int price = 30000;
		int discountPrice = discountService.discount(member, price, "rateDiscountPolicy");
		
		assertThat(discountService).isInstanceOf(DiscountService.class);
		assertThat(discountPrice).isEqualTo(price/10);
	}
	
	static class DiscountService {
		
		// map 의 Key 에 스프링 빈의 이름을 넣어주고, 그에 대한 Value 로 
		// DiscountPolicy 타입으로 조회한 모든 스프링 빈을 담아준다.
		private final Map<String, DiscountPolicy> discountPolicyMap;
		// DiscountPolicy 타입으로 조회한 모든 스프링 빈을 담아준다.
		private final List<DiscountPolicy> policyList;

		@Autowired
		public DiscountService(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> policyList) {
			this.discountPolicyMap = discountPolicyMap;
			this.policyList = policyList;
			System.out.println(discountPolicyMap);
			System.out.println(policyList);
		}
		
		public int discount(Member member, int price, String discountCode) {
			
			DiscountPolicy discountPolicy = discountPolicyMap.get(discountCode);
			
			System.out.println("discountCode : " + discountCode);
			System.out.println("discountPolicy : " + discountPolicy);
			
			return discountPolicy.discount(member, price);
		}
		
	}
	
}
