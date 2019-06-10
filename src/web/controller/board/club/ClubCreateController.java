package web.controller.board.club;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;
import web.dto.club.Club;


@WebServlet("/board/club/create")
public class ClubCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClubDao clubDao = new ClubDaoImpl();

	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/board/club/club_create.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// - - - MultipartRequest �깮�꽦�옄�쓽 留ㅺ컻蹂��닔 以�鍮� - - -

		//1. �슂泥� 媛앹껜 - �뵲濡� 留뚮뱾 �븘�슂 �뾾�쓬

		//2. �뙆�씪 ���옣 �쐞移� - �꽌踰꾩쓽 real path
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");

		System.out.println(saveDirectory);

		//3. �뾽濡쒕뱶 �젣�븳 �궗�씠利� - 10MB
		int maxPostSize = 10 * 1024* 1024;

		//4. �씤肄붾뵫 - utf-8
		String encoding = "UTF-8";

		//5. 以묐났 �뙆�씪 �씠由� �젙梨� - 湲곕낯 �젙梨�
		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		// ----------------------------------------------

		//�뙆�씪 �뾽濡쒕뱶 媛앹껜 �깮�꽦
		MultipartRequest mul = new MultipartRequest (
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy );
		
		HttpSession session = req.getSession();
		Club club = new Club();
		club.setClub_originname(mul.getOriginalFileName("upfile"));
		club.setClub_storedname(mul.getFilesystemName("upfile"));
		
		String title = mul.getParameter("title");
		
		String[] subject = mul.getParameterValues("subject");
		int sub = 0;
		for(int i=0; i < subject.length; i++){
			if(subject[i]!= null && !"".equals(subject[i])) {
				sub = Integer.parseInt(subject[i]);
				break;
			}
		}
		club.setClub_tag(sub);
		
		String content = mul.getParameter("content");
		String member_id = (String)session.getAttribute("member_id");
		club.setMember_id(member_id);
		club.setClub_title(title);
		club.setClub_include(content);
		
		clubDao.insert(club);
		
		resp.sendRedirect("/board/club");
	}
}
