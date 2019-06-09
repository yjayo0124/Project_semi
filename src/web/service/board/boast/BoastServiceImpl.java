package web.service.board.boast;

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

import web.dao.board.boast.BoastDao;
import web.dao.board.boast.BoastDaoImpl;
import web.dao.board.boast.CommentDao;
import web.dao.board.boast.CommentDaoImpl;
import web.dao.board.boast.RecommendDao;
import web.dao.board.boast.RecommendDaoImpl;
import web.dto.Comment;
import web.dto.boast.BoastBoard;
import web.dto.boast.BoastComment;
import web.dto.boast.BoastFile;
import web.dto.boast.Recommend;
import web.util.boast.BoastPaging;

public class BoastServiceImpl implements BoastService{

	private BoastDao boastDao = new BoastDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl() ;
	private RecommendDao recommendDao = new RecommendDaoImpl() ;
	@Override
	public List getList(BoastPaging paging) {
		return boastDao.selectAll(paging);
	}

	@Override
	public BoastPaging getCurPage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		String search = (String)req.getParameter("search");
		
		int totalCount = boastDao.selectCntAll(search);
		
		BoastPaging paging = new BoastPaging(totalCount, curPage);
		paging.setSearch(search);
		
		return paging;
	}

	@Override
	public BoastBoard getBoardno(HttpServletRequest req) {
		
		String param = req.getParameter("boast_board_no");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		BoastBoard board = new BoastBoard();
		board.setBoast_board_no(boardno);
		
		return board;
	}

	@Override
	public BoastBoard view(BoastBoard viewBoard) {
		
		boastDao.updateHit(viewBoard);
		return boastDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void write(HttpServletRequest req) {
		BoastBoard board = null;
		BoastFile boardFile =  null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			return;
			
		} else {
			board = new BoastBoard();

			DiskFileItemFactory factory = new DiskFileItemFactory();

			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			Iterator<FileItem> iter = items.iterator();
			
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				if( item.getSize() <= 0 )	continue;
				
				if( item.isFormField() ) {
					
					try {
						
						if( "boast_board_title".equals( item.getFieldName() ) ) {
								board.setBoast_board_title( item.getString("utf-8") );
						}
						
						if( "boast_board_content".equals( item.getFieldName() ) ) {
							board.setBoast_board_content( item.getString("utf-8") );
						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					board.setBoast_board_writer((String) req.getSession().getAttribute("member_id"));
					
				} else {
					UUID uuid = UUID.randomUUID();
					//System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
					//System.out.println(u);
					// -----------------
					
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					boardFile = new BoastFile();
					boardFile.setBoast_board_origin_name(item.getName());
					boardFile.setBoast_board_stored_name(stored);
					
					try {
						item.write(up);
						
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		
		int boardno = boastDao.selectBoardno();
		
		if(board != null) {
			board.setBoast_board_no(boardno);
			
			if(board.getBoast_board_title()==null ||"".equals(board.getBoast_board_title())) {
				board.setBoast_board_title("(제목없음)");
				
				board.setBoast_board_writer((String) req.getSession().getAttribute("member_id"));
			}
			
			boastDao.insert(board);
		}
		
		if(boardFile != null) {
			boardFile.setBoast_board_no(boardno);
			boastDao.insertFile(boardFile);
		}
	}

	@Override
	public BoastFile viewFile(BoastBoard viewBoard) {
		return boastDao.selectFile(viewBoard);
	}

	@Override
	public boolean checkWriter(HttpServletRequest req) {
		
		String loginId = (String) req.getSession().getAttribute("member_id");

		BoastBoard board = getBoardno(req);
		
		board = boastDao.selectBoardByBoardno(board);

		if( !loginId.equals(board.getBoast_board_writer()) ) {
			return false;
		}
		
		return true;
	}

	@Override
	public void update(HttpServletRequest req) {
		BoastBoard board =  null;
		BoastFile boardFile = null;
		
	boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			board = new BoastBoard();
			
			board.setBoast_board_title(req.getParameter("boast_board_title"));
			board.setBoast_board_writer((String) req.getSession().getAttribute("boast_board_writer"));
			board.setBoast_board_content(req.getParameter("boast_board_content"));
			
		} else {
			board = new BoastBoard();

			DiskFileItemFactory factory = new DiskFileItemFactory();

			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			Iterator<FileItem> iter = items.iterator();
			
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				if( item.getSize() <= 0 )	continue;
				
				if( item.isFormField() ) {
					try {
						if( "boast_board_no".equals( item.getFieldName() ) ) {
							board.setBoast_board_no( Integer.parseInt(item.getString()) );
						}
	
						if( "boast_board_title".equals( item.getFieldName() ) ) {
							board.setBoast_board_title( item.getString("utf-8") ); 
						}
						if( "boast_board_content".equals( item.getFieldName() ) ) {
							board.setBoast_board_content( item.getString("utf-8") );
						}
						
						board.setBoast_board_writer((String) req.getSession().getAttribute("boast_board_writer"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
					
					String u = uuid.toString().split("-")[4];
					
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					boardFile = new BoastFile();
					boardFile.setBoast_board_origin_name(item.getName());
					boardFile.setBoast_board_stored_name(stored);
					
					try {
						item.write(up);
						
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		if(board != null) {
			boastDao.update(board);
		}
		
		if(boardFile != null) {
			boardFile.setBoast_board_no(board.getBoast_board_no());
			boastDao.insertFile(boardFile);
		}

	}

	@Override
	public void delete(BoastBoard board) {
		
		boastDao.delete(board);
		
		boastDao.deleteFile(board);
		
	}

	@Override
	public BoastComment getComment(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String boast_board_no = (String) req.getParameter("boast_board_no");
		String member_id = (String) req.getParameter("member_id");
		String boast_content = (String) req.getParameter("boast_content");
		
		BoastComment comment = new BoastComment() ;
		comment.setBoast_board_no( Integer.parseInt( boast_board_no ) ) ;
		comment.setMember_id(member_id);
		comment.setBoast_content(boast_content);
		
		return comment;
	}

	@Override
	public void insertComment(BoastComment comment) {
		commentDao.insertComment( comment ) ;
		
	}



	@Override
	public boolean deleteComment(BoastComment comment) {
		commentDao.deleteComment(comment);
		
		if( commentDao.countComment(comment) > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List getCommentList(BoastBoard board) {
		return commentDao.selectComment( board ) ;
	}

	@Override
	public boolean isRecommend(Recommend recommend) {
		int cnt = recommendDao.selectCntRecommend(recommend);
		
		if(cnt > 0) { //추천했음
			return true;
			
		} else { //추천하지 않았음
			return false;
			
		}
	}

	@Override
	public Recommend getRecommend(HttpServletRequest req) {
		//전달파라미터 파싱
		int boardno = 0;
		String param = req.getParameter("boast_board_no");
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}

		//로그인한 아이디
		String userid = (String) req.getSession().getAttribute("member_id");

		Recommend recommend = new Recommend();
		recommend.setBoast_board_no(boardno);
		recommend.setMember_id(userid);

		return recommend;
	}

	@Override
	public boolean recommend(Recommend recommend) {
		if( isRecommend(recommend) ) { //추천한 상태
			recommendDao.deleteRecommend(recommend);
			
			return false;
			
		} else { //추천하지 않은 상태
			recommendDao.insertRecommend(recommend);
			
			return true;
			
		}
	}

	@Override
	public int getTotalCntRecommend(Recommend recommend) {
		return recommendDao.selectTotalCntRecommend(recommend);
	}
	
}
