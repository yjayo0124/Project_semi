package web.service.member;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.MemberDetail;
import web.dto.Notice;
import web.util.Paging;

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
		String member_birthday = req.getParameter("member_birthday");
			
			try {
				Date date;
				date = new SimpleDateFormat("yyyy-mm-dd").parse(member_birthday);
				member.setMember_birthday(date);
			} catch (ParseException e) {	
				e.printStackTrace();
			}
			
		
		
		member.setMember_id(req.getParameter("member_id"));
		member.setMember_pw(req.getParameter("member_pw2"));
		member.setMember_nick(req.getParameter("member_nick"));
		member.setMember_name(req.getParameter("member_name"));
		member.setMember_gender(req.getParameter("member_gender"));
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

	@Override
	public MemberDetail getMemberByMemberpw(MemberDetail member) {
		return memberDao.selectMemberByMemberpw(member);
	}

	@Override
	public void deleteMemberByMemberid(MemberDetail member) {
		 memberDao.deleteMember(member);

	}


	@Override
	public void updateMemberByMemberid(MemberDetail member) {
	
		
		 memberDao.updateMember(member);

	}


	public Paging getCurPage(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
						
		String search = (String)req.getParameter("search");
				
		int totalCount = memberDao.selectCntAll(search);
						
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
				
		return paging;
	}
	@Override
	public List getList(Paging paging) {
	
		return memberDao.selectAll(paging);
	}
	@Override
	public void forceoutMember(MemberDetail member) {
		
		
		
		memberDao.memberforceout(member);
		
		
		
	}
	
	public MemberDetail getMemberId(HttpServletRequest req) {
		
		String member_id = req.getParameter("member_id");
		
		MemberDetail member = new MemberDetail();
		
		member.setMember_id(member_id);
		
		return member;
	}

	

}
