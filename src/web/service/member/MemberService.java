package web.service.member;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	public Member getLoginMember(HttpServletRequest req);
	
	boolean login(Member member);
	
	public Member getMemberByMemberid(Member member);
}
