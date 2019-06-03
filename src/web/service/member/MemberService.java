package web.service.member;

import javax.servlet.http.HttpServletRequest;

import web.dto.MemberDetail;

public interface MemberService {

	public MemberDetail getLoginMember(HttpServletRequest req);
	
	
	boolean login(MemberDetail MemberDetail);
	
	
	public MemberDetail getMemberByMemberid(MemberDetail MemberDetail);

	public MemberDetail getMemberByMemberpw(MemberDetail MemberDetail);


	public MemberDetail getJoinMember(HttpServletRequest req);

	
	/**
	 * 회원가입
	 * 
	 * @param MemberDetail - 회원가입 정보 객체
	 */
	public void join(MemberDetail MemberDetail);


	public void deleteMemberByMemberid(MemberDetail member);

}
