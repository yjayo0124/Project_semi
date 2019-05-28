package web.service.member;

import javax.servlet.http.HttpServletRequest;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member getLoginMember(HttpServletRequest req) {
		
		Member member = new Member();
		
		member.setMember_id(req.getParameter("member_id"));
		member.setMember_pw(req.getParameter("member_pw"));
		
		return member;
	}

	@Override
	public boolean login(Member member) {
		
		if( memberDao.selectCntMemberByMemberidAndMemberpw(member) >= 1 ) {
			//로그인 성공
			return true;

		} else {
			//로그인 실패
			return false;
			
		}
	}

	@Override
	public Member getMemberByMemberid(Member member) {
		
		return memberDao.selectMemberByMemberid(member);
	}
	

	

}
