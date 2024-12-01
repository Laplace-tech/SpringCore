package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		MemberService memberService = AppConfig.memberService();
		Member member = new Member(1L, "G-DRAGON", Grade.VIP);
		memberService.join(member);
		
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}	
	
}
