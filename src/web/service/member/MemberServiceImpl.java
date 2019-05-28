package web.service.member;

import javax.servlet.http.HttpServletRequest;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.MemberDetail;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public MemberDetail getLoginMember(HttpServletRequest req) {
		
		MemberDetail member = new MemberDetail();
		
		member.setMember_id(req.getParameter("member_id"));
		member.setMember_pw(req.getParameter("member_pw"));
		
		return member;
	}

	@Override
	public boolean login(MemberDetail member) {
		
		if( memberDao.selectCntMemberByMemberidAndMemberpw(member) >= 1 ) {
			//로그인 성공
			return true;

		} else {
			//로그인 실패
			return false;
			
		}
	}

	@Override
	public MemberDetail getMemberByMemberid(MemberDetail member) {
		
		return memberDao.selectMemberByMemberid(member);
	}
	
	
	@Override
	public MemberDetail getJoinMember(HttpServletRequest req) {
		MemberDetail member = new MemberDetail();
		
		member.setMember_id(req.getParameter("member_id"));
		member.setMember_pw(req.getParameter("member_pw"));
		member.setMember_nick(req.getParameter("member_nick"));
		member.setMember_name(req.getParameter("member_name"));
		member.setMember_gender(req.getParameter("member_gender"));
		member.setMember_birthday((String)req.getParameter("member_birthday"));
		member.setMember_email(req.getParameter("member_email"));
		member.setMember_phone(req.getParameter("member_phone"));

		// 전달파라미터 member_group 파싱
		String param = req.getParameter("member_group");
		int memberGroup = 0;
		if( param!=null && !"".equals(param) ) {
			memberGroup = Integer.parseInt(param);
		}
		member.setMember_group(memberGroup);

			
		return member;
	}
	
		

	@Override
	public void join(MemberDetail member) {
		
		memberDao.insert(member);
	}


	

}
