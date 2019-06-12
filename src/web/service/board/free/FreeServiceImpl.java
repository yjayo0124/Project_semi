package web.service.board.free;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.board.free.FreeCommentDao;
import web.dao.board.free.FreeCommentDaoImpl;
import web.dao.board.free.FreeDao;
import web.dao.board.free.FreeDaoImpl;
import web.dto.FreeBoard;
import web.dto.FreeComment;
import web.dto.FreeFile;
import web.util.Paging;

public class FreeServiceImpl implements FreeService{

	private FreeDao freeDao = new FreeDaoImpl();
	private FreeCommentDao commentDao = new FreeCommentDaoImpl();

	
	@Override
	public List getList(Paging paging) {
		return freeDao.selectAll(paging);
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		
		// �쟾�떖�뙆�씪誘명꽣 curPage �뙆�떛
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//寃��깋�뼱
		String select = (String)req.getParameter("select");
		String search = (String)req.getParameter("search");

		
		// �쟾泥� 寃뚯떆湲� �닔
		int totalCount = freeDao.selectCntAll(select,search);
		
		// �럹�씠吏� 媛앹껜 �깮�꽦
		Paging paging = new Paging(totalCount, curPage);
		paging.setSelect(select);
		paging.setSearch(search); //**以묒슂 search 媛� �럹�씠吏� 媛앹껜�뿉 ���옣
//		System.out.println(paging); //TEST
		
		return paging;
	}

	@Override
	public FreeBoard getBoardno(HttpServletRequest req) {
		
		// �쟾�떖�뙆�씪誘명꽣 boardno �뙆�떛
		String param = req.getParameter("free_board_no");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//Board 媛앹껜 �깮�꽦
		FreeBoard board = new FreeBoard();
		board.setFree_board_no(boardno);
		
		return board;
	}

	@Override
	public FreeBoard view(FreeBoard viewBoard) {
		
		//寃뚯떆湲� 議고쉶�닔 +1
		freeDao.updateHit(viewBoard);
		
		//寃뚯떆湲� 議고쉶 諛섑솚
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
			//�뙆�씪�뾽濡쒕뱶瑜� �궗�슜�븯怨� �엳�쓣 寃쎌슦
			board = new FreeBoard();

			//�뵒�뒪�겕�뙥�넗由�
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//硫붾え由ъ쿂由� �궗�씠利�
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//�엫�떆 ���옣�냼
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//�뾽濡쒕뱶 媛앹껜 �깮�꽦
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//�슜�웾 �젣�븳 �꽕�젙 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 異붿텧 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//�뙆�떛�맂 �뜲�씠�꽣 泥섎━ 諛섎났�옄
			Iterator<FileItem> iter = items.iterator();
			
			//�슂泥��젙蹂� 泥섎━
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 鍮� �뙆�씪 泥섎━
				if( item.getSize() <= 0 )	continue;
				
				// 鍮� �뙆�씪�씠 �븘�땺 寃쎌슦
				if( item.isFormField() ) {
					
					try {
						
						//�젣紐� 泥섎━
						if( "free_board_title".equals( item.getFieldName() ) ) {
								board.setFree_board_title( item.getString("utf-8") );
						}
						
						//蹂몃Ц 泥섎━
						if( "free_board_content".equals( item.getFieldName() ) ) {
							board.setFree_board_content( item.getString("utf-8") );
						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					//�옉�꽦�옄id 泥섎━
					board.setFree_board_writer((String) req.getSession().getAttribute("member_nick"));
					board.setMember_id((String) req.getSession().getAttribute("member_id"));
						
				} else {
					UUID uuid = UUID.randomUUID();
					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
					System.out.println(u);
					// -----------------
					
					//濡쒖뺄 ���옣�냼 �뙆�씪
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("freeupload")
						, stored);
					
					boardFile = new FreeFile();
					boardFile.setFree_board_file_origin_name(item.getName());
					boardFile.setFree_board_file_stored_name(stored);
//					boardFile.setFilesize(item.getSize());
					
					try {
						// �떎�젣 �뾽濡쒕뱶
						item.write(up);
						
						// �엫�떆 �뙆�씪 �궘�젣
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
				board.setFree_board_title("(�젣紐⑹뾾�쓬)");

				//�옉�꽦�옄id 泥섎━
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
		//濡쒓렇�씤�븳 �꽭�뀡 ID �뼸湲�
		String loginId = (String) req.getSession().getAttribute("member_id");

		//�옉�꽦�븳 寃뚯떆湲� 踰덊샇 �뼸湲�
		FreeBoard board = getBoardno(req);
		
		//寃뚯떆湲� �뼸�뼱�삤湲�
		board = freeDao.selectBoardByBoardno(board);

		//寃뚯떆湲��쓽 �옉�꽦�옄�� 濡쒓렇�씤 �븘�씠�뵒 鍮꾧탳
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
			//�뙆�씪 泥⑤�媛� �뾾�쓣 寃쎌슦
			board = new FreeBoard();
			
			board.setFree_board_title(req.getParameter("free_board_title"));
			board.setFree_board_writer((String) req.getSession().getAttribute("free_board_writer"));
			board.setFree_board_content(req.getParameter("free_board_content"));
			
		} else {
			//�뙆�씪�뾽濡쒕뱶瑜� �궗�슜�븯怨� �엳�쓣 寃쎌슦
			board = new FreeBoard();

			//�뵒�뒪�겕�뙥�넗由�
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//硫붾え由ъ쿂由� �궗�씠利�
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//�엫�떆 ���옣�냼
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//�뾽濡쒕뱶 媛앹껜 �깮�꽦
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//�슜�웾 �젣�븳 �꽕�젙 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 異붿텧 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//�뙆�떛�맂 �뜲�씠�꽣 泥섎━ 諛섎났�옄
			Iterator<FileItem> iter = items.iterator();
			
			//�슂泥��젙蹂� 泥섎━
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 鍮� �뙆�씪 泥섎━
				if( item.getSize() <= 0 )	continue;
				
				// 鍮� �뙆�씪�씠 �븘�땺 寃쎌슦
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
					
					//濡쒖뺄 ���옣�냼 �뙆�씪
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("freeupload")
						, stored);
					
					boardFile = new FreeFile();
					boardFile.setFree_board_file_origin_name(item.getName());
					boardFile.setFree_board_file_stored_name(stored);
//					boardFile.setFilesize(item.getSize());
					
					try {
						// �떎�젣 �뾽濡쒕뱶
						item.write(up);
						
						// �엫�떆 �뙆�씪 �궘�젣
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

	@Override
	public FreeComment getComment(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String boardNo = (String) req.getParameter("free_board_no");
		String membernick = (String) req.getParameter("member_nick");
		String content = (String) req.getParameter("free_board_content");
		
		FreeComment comment = new FreeComment();
		comment.setFree_board_no( Integer.parseInt(boardNo) );
		comment.setMember_id(membernick);
		comment.setFree_board_content(content);
		
		return comment;

	}

	@Override
	public void insertComment(FreeComment comment) {
		commentDao.insertComment(comment);
		
	}

	@Override
	public List getCommentList(FreeBoard viewBoard) {
		return commentDao.selectComment(viewBoard);
	}

	@Override
	public boolean deleteComment(FreeComment comment) {
		commentDao.deleteComment(comment);
		
		if( commentDao.countComment(comment) > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public HashMap getPrevNext(FreeBoard viewBoard) {
		return freeDao.getPrevNext(viewBoard);
	}

	@Override
	public HashMap getPrevNextName(FreeBoard viewBoard) {
		return freeDao.getPrevNextName(viewBoard);
	}		
	

	
}
