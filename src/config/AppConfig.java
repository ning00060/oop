package config;

import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import order.DiscountPolicy;
import order.FixDiscountPolicyImpl;
import order.OrderService;
import order.OrderServiceImpl;
import order.PercentDiscountPolicyImpl;

public class AppConfig {

	public MemberRepository getMemberRepository() {
		return MemoryMemberRepositoryImpl.getInstance();
	}
	public MemberService  getmeMemberService() {
		return new MemberServiceImpl(getMemberRepository());
	}
	public DiscountPolicy getDiscountPolicy() {
		// 할인 정책이 --> 고정 할인
		// 변경 --정율 할인 바꾼다
		// 이부분만 변경하면 되빈다,.
//		 return new FixDiscountPolicyImpl();
		return new PercentDiscountPolicyImpl();
	}
	
	public OrderService getOrderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}
}
