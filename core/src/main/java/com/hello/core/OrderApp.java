package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		
		MemberService memberService = AppConfig.memberService();
		OrderService orderService = AppConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "G-DRAGON", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(member.getId(), "POWER", 30000);
		System.out.println(order);
		System.out.println(order.calculatePrice());
		
	}
	
}
