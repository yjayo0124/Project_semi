package web.controller.board.festival;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dao.board.festival.FestivalFileDao;
import web.dao.board.festival.FestivalFileDaoImpl;
import web.dto.festival.FestivalBoard;
import web.dto.festival.FestivalFile;
import web.service.board.festival.FestivalService;
import web.service.board.festival.FestivalServiceImpl;

@WebServlet("/board/festival/write")
public class FestivalWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FestivalService festivalService = new FestivalServiceImpl();
	private FestivalFileDao festivalFileDao = new FestivalFileDaoImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/festival/festival_write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// - - - MultipartRequest 생성자의 매개변수 준비 - - -

				//1. 요청 객체 - 따로 만들 필요 없음

				//2. 파일 저장 위치 - 서버의 real path
				ServletContext context = getServletContext();
				String saveDirectory = context.getRealPath("upload");

				System.out.println(saveDirectory);

				//3. 업로드 제한 사이즈 - 10MB
				int maxPostSize = 10 * 1024* 1024;

				//4. 인코딩 - utf-8
				String encoding = "UTF-8";

				//5. 중복 파일 이름 정책 - 기본 정책
				FileRenamePolicy policy = new DefaultFileRenamePolicy();

				// ----------------------------------------------

				//파일 업로드 객체 생성
				MultipartRequest mul = new MultipartRequest (
						req,
						saveDirectory,
						maxPostSize,
						encoding,
						policy );
				

				FestivalBoard board = new FestivalBoard();
				
				String title = mul.getParameter("title");
				String host = mul.getParameter("host");
				String content = mul.getParameter("content");
				String phone = mul.getParameter("phone");
				String web = mul.getParameter("web");
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
				try {
					Date start = date.parse(mul.getParameter("start"));
					Date end = date.parse(mul.getParameter("end"));
					
					board.setFestival_start(start);
					board.setFestival_end(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String fee = mul.getParameter("fee");
				
				
				board.setFestival_title(title);
				board.setFestival_host(host);
				board.setFestival_content(content);
				board.setFestival_phone(phone);
				board.setFestival_web(web);
				board.setFestival_fee(fee);
				

				req.setAttribute("Board", board);
				festivalService.write(board);
				
				
				FestivalFile file = new FestivalFile();
				file.setFestival_originname(mul.getOriginalFileName("upfile"));
				file.setFestival_storedname(mul.getFilesystemName("upfile"));

				festivalFileDao.insert(file);
				req.setAttribute("file", file);
		
		
		resp.sendRedirect("/board/fastival");
		
	}
}
