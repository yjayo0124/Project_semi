package web.service.board.club;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;
import web.dto.club.ClubBoard;
import web.util.club.ClubPaging;

public class ClubServiceImpl implements ClubService {

	private ClubDao clubDao = new ClubDaoImpl(); 

	@Override
	public List getList(ClubPaging paging) {

		return clubDao.selectAll(paging);
	}

	@Override
	public ClubPaging getCurpage(HttpServletRequest req) {

		String param = req.getParameter("club_tag");
		int club_tag = 1;
		if(param!=null && !"".equals(param)) {
			club_tag = Integer.parseInt(param);
		}

		String param2 = req.getParameter("curPage");
		int curPage = 0;
		if(param2!=null && !"".equals(param2)) {
			curPage = Integer.parseInt(param2);
		}


		int totalCount = clubDao.selectCntAll(club_tag);
		ClubPaging paging = new ClubPaging(totalCount,curPage);
		paging.setClub_tag(club_tag);

		return paging;
	}

	@Override
	public ClubPaging getBoardCurpage(HttpServletRequest req, int club_no) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		int totalCount = clubDao.selectBoardCntAll(club_no);
		ClubPaging paging = new ClubPaging(totalCount,curPage);
		paging.setClub_no(club_no);

		return paging;
	}

	@Override
	public int write(HttpServletRequest req) {

		ClubBoard clubBoard = null;
		int club_no = 0;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			return 0;
			
		} else {
			//파일업로드를 사용하고 있을 경우
			clubBoard = new ClubBoard();

			//디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//임시 저장소
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					
					try {
						if( "club_no".equals( item.getFieldName() ) ) {
							String clubno = item.getString("utf-8");
							club_no = Integer.parseInt(clubno);
							clubBoard.setClub_no(club_no);
						}
						
						
						//제목 처리
						if( "title".equals( item.getFieldName() ) ) {
							clubBoard.setClub_board_title( item.getString("utf-8") );
						}
						
						//본문 처리
						
						if( "content".equals( item.getFieldName() ) ) {
							clubBoard.setClub_board_content( item.getString("utf-8") );
						}
						
						
						
						
						// -----------------------------------------------
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					//작성자id 처리
					clubBoard.setClub_board_writer((String) req.getSession().getAttribute("member_nick"));
					clubBoard.setMember_id((String) req.getSession().getAttribute("member_id"));
					
				} else {
					UUID uuid = UUID.randomUUID();
//					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
//					System.out.println(u);
					// -----------------
					
					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		

		
		if(clubBoard != null) {
			
			if(clubBoard.getClub_board_title()==null || "".equals(clubBoard.getClub_board_title())) {
				clubBoard.setClub_board_title("(제목없음)");

				//작성자id 처리
				clubBoard.setMember_id((String) req.getSession().getAttribute("member_id"));
			}
			
			clubDao.insert(clubBoard);
		}
		return club_no;
		
	}

}




