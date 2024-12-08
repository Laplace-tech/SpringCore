package com.hello.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderService orderService;
	
//	@BeforeEach
//	public void BeforeEach() {
//		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//		memberService = ac.getBean(MemberService.class);
//		orderService = ac.getBean(OrderService.class);
//	}
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "G-DRAGON", Grade.VIP);
		memberService.join(member);
		
		int price = 20000;
		Order order = orderService.createOrder(member.getId(), "POWER", price);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(price/10);
	}
	
	
}
