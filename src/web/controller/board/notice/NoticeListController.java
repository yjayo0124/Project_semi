package web.controller.board.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.MemberDetail;
import web.service.board.notice.NoticeService;
import web.service.board.notice.NoticeServiceImpl;
import web.util.Paging;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/board/notice/list")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService = new NoticeServiceImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//��û�Ķ���Ϳ��� curPage ������
		Paging paging = noticeService.getCurPage(req);
				
		//MODEL�� Paging ��ü �ֱ�
		req.setAttribute("paging", paging);
							
		//�Խ��� ��� ��ȸ
		List list = noticeService.getList(paging);
				
		//MODEL�� ��ȸ ��� �ֱ�
		req.setAttribute("list", list);
		//---------------------------------------
		
		
		//���������� �Ϲݻ�������� Ȯ���ѵ� parameter�� �� ������
		int res = 0;
			
//		System.out.println(req.getSession().getAttribute("member_id"));
		
		if( req.getSession().getAttribute("member_id") != null) {
		
			int memCode = (int) req.getSession().getAttribute("member_code");
	
			res = memberDao.checkMemberCode(memCode);
		
		}
		req.setAttribute("res", res);
		
		//---------------------------------����ڵ� üũ�ѵ� �������̸� 1/ �Ϲݻ�����̸� 0�� ���� req�� ����!!
		
		

		req.getRequestDispatcher("/WEB-INF/views/board/notice/list.jsp").forward(req, resp);
	
	}
	
    
}
