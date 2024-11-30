package com.hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hello.core.AppConfig;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;

public class OrderServiceTest {
	
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void BeforeEach() {
		memberService = AppConfig.memberService();
		orderService = AppConfig.orderService();
	}
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "G-DRAGON", Grade.VIP);
		memberService.join(member);
		
		int price = 20000;
		Order order = orderService.createOrder(member.getId(), "POWER", price);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
	
}
