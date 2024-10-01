package member.service;

import member.Member;

public interface MemberService {

	void signUP(Member member);
	Member findByIdMember(Long memberId);
}
