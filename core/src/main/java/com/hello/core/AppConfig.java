package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {

	private static MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	private static DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}

	public static MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public static OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

}
