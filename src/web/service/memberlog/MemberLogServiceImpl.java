package web.service.memberlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.dao.memberlog.MemberLogDao;
import web.dao.memberlog.MemberLogDaoImpl;
import web.dto.LoginLog;
import web.util.Paging;

public class MemberLogServiceImpl implements MemberLogService {
		MemberLogDao memberLogDao = new MemberLogDaoImpl();
		
	@Override
	public Paging getCurPage(HttpServletRequest req) {
	
		//세션 얻어 오기
		HttpSession session = req.getSession();

		// �쟾�떖�뙆�씪誘명꽣 curPage �뙆�떛
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		

		String search = (String)req.getParameter("search");
		
		LoginLog log = new LoginLog();
		log.setMember_id((String)session.getAttribute("member_id"));
		
		// �쟾泥� 寃뚯떆湲� �닔
		int totalCount = memberLogDao.selectCntAll(search,log);
		
		// �럹�씠吏� 媛앹껜 �깮�꽦
		Paging paging = new Paging(totalCount);

		paging.setSearch(search); //**以묒슂 search 媛� �럹�씠吏� 媛앹껜�뿉 ���옣
//		System.out.println(paging); //TEST
		
		return paging;
	}

	@Override
	public List getList(Paging paging, LoginLog log) {
		return memberLogDao.selectAll(paging, log);
	}

	@Override
	public void insertLoginLog(LoginLog log) {
		memberLogDao.insertLog(log);
	}

}
