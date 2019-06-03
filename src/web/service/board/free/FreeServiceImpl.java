package web.service.board.free;

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

import web.dao.board.free.FreeDao;
import web.dao.board.free.FreeDaoImpl;
import web.dto.FreeBoard;
import web.dto.FreeFile;
import web.util.Paging;

public class FreeServiceImpl implements FreeService{

	private FreeDao freeDao = new FreeDaoImpl();
	
	@Override
	public List getList(Paging paging) {
		return freeDao.selectAll(paging);
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		
		// 전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//검색어
		String search = (String)req.getParameter("search");

		
		// 전체 게시글 수
		int totalCount = freeDao.selectCntAll(search);
		
		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search); //**중요 search 값 페이징 객체에 저장
//		System.out.println(paging); //TEST
		
		return paging;
	}

	@Override
	public FreeBoard getBoardno(HttpServletRequest req) {
		
		// 전달파라미터 boardno 파싱
		String param = req.getParameter("free_board_no");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//Board 객체 생성
		FreeBoard board = new FreeBoard();
		board.setFree_board_no(boardno);
		
		return board;
	}

	@Override
	public FreeBoard view(FreeBoard viewBoard) {
		
		//게시글 조회수 +1
		freeDao.updateHit(viewBoard);
		
		//게시글 조회 반환
		return freeDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void write(HttpServletRequest req) {
		FreeBoard board = null;
		FreeFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			return;
			
		} else {
			//파일업로드를 사용하고 있을 경우
			board = new FreeBoard();

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
						
						//제목 처리
						if( "free_board_title".equals( item.getFieldName() ) ) {
								board.setFree_board_title( item.getString("utf-8") );
						}
						
						//본문 처리
						if( "free_board_content".equals( item.getFieldName() ) ) {
							board.setFree_board_content( item.getString("utf-8") );
						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					//작성자id 처리
					board.setFree_board_writer((String) req.getSession().getAttribute("member_id"));
					
				} else {
					UUID uuid = UUID.randomUUID();
					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
					System.out.println(u);
					// -----------------
					
					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("freeupload")
						, stored);
					
					boardFile = new FreeFile();
					boardFile.setFree_board_file_origin_name(item.getName());
					boardFile.setFree_board_file_stored_name(stored);
//					boardFile.setFilesize(item.getSize());
					
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
		

		int boardno = freeDao.selectBoardno();
		
		if(board != null) {
			board.setFree_board_no(boardno);
			
			if(board.getFree_board_title()==null || "".equals(board.getFree_board_title())) {
				board.setFree_board_title("(제목없음)");

				//작성자id 처리
				board.setFree_board_writer((String) req.getSession().getAttribute("member_id"));
			}

			freeDao.insert(board);
		}
		
		if(boardFile != null) {
			boardFile.setFree_board_no(boardno);
			freeDao.insertFile(boardFile);
		}
	
	
		
	}

	@Override
	public FreeFile viewFile(FreeBoard viewBoard) {
		return freeDao.selectFile(viewBoard);	
		
	}

	@Override
	public boolean checkWriter(HttpServletRequest req) {
		//로그인한 세션 ID 얻기
		String loginId = (String) req.getSession().getAttribute("member_id");

		//작성한 게시글 번호 얻기
		FreeBoard board = getBoardno(req);
		
		//게시글 얻어오기
		board = freeDao.selectBoardByBoardno(board);

		//게시글의 작성자와 로그인 아이디 비교
		if( !loginId.equals(board.getFree_board_writer()) ) {
			return false;
		}
		
		return true;
	}

	@Override
	public void update(HttpServletRequest req) {
		FreeBoard board = null;
		FreeFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없을 경우
			board = new FreeBoard();
			
			board.setFree_board_title(req.getParameter("free_board_title"));
			board.setFree_board_writer((String) req.getSession().getAttribute("free_board_writer"));
			board.setFree_board_content(req.getParameter("free_board_content"));
			
		} else {
			//파일업로드를 사용하고 있을 경우
			board = new FreeBoard();

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
						if( "free_board_no".equals( item.getFieldName() ) ) {
							board.setFree_board_no( Integer.parseInt(item.getString()) );
						}
	
						if( "free_board_title".equals( item.getFieldName() ) ) {
							board.setFree_board_title( item.getString("utf-8") ); 
						}
						if( "free_board_content".equals( item.getFieldName() ) ) {
							board.setFree_board_content( item.getString("utf-8") );
						}
						
						board.setFree_board_writer((String) req.getSession().getAttribute("free_board_writer"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
//					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
//					System.out.println(u);
					// -----------------
					
					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("freeupload")
						, stored);
					
					boardFile = new FreeFile();
					boardFile.setFree_board_file_origin_name(item.getName());
					boardFile.setFree_board_file_stored_name(stored);
//					boardFile.setFilesize(item.getSize());
					
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
		

//		System.out.println(board);
//		System.out.println(boardFile);
		
		if(board != null) {
			freeDao.update(board);
		}
		
		if(boardFile != null) {
			boardFile.setFree_board_file_no(board.getFree_board_no());
			freeDao.insertFile(boardFile);
		}
	}

	@Override
	public void delete(FreeBoard board) {

		
		
		freeDao.delete(board);
			
		freeDao.deleteFile(board);
		
	}		
	

	
}
