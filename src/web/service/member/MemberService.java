package web.service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.MemberDetail;
import web.util.Paging;

public interface MemberService {

	public MemberDetail getLoginMember(HttpServletRequest req);
	
	
	boolean login(MemberDetail MemberDetail);
	
	
	public MemberDetail getMemberByMemberid(MemberDetail MemberDetail);

	public MemberDetail getMemberByMemberpw(MemberDetail MemberDetail);


	public MemberDetail getJoinMember(HttpServletRequest req);

	public Paging getCurPage(HttpServletRequest req);
	/**
	 * 회원가입
	 * 
	 * @param MemberDetail - 회원가입 정보 객체
	 */
	public void join(MemberDetail MemberDetail);


	public void deleteMemberByMemberid(MemberDetail member);



	public void updateMemberByMemberid(MemberDetail member);



	public List getList(Paging paging);


	public void forceoutMember(MemberDetail member);
	
	public MemberDetail getMemberId(HttpServletRequest req);

}
