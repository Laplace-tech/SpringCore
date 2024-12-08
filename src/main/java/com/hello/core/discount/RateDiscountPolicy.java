package com.hello.core.discount;

import org.springframework.stereotype.Component;

import com.hello.core.annotation.MainDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;

//@Primary
//@Qualifier("mainDiscountPolicy")
@Component
@MainDiscountPolicy // 굳이? 
public class RateDiscountPolicy implements DiscountPolicy {

	private final int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		return member.getGrade() == Grade.VIP ? price * discountPercent / 100 : 0;
	}
	
}
