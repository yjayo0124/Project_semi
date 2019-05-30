package web.service.board.free;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
		
		// �쟾泥� 寃뚯떆湲� �닔
		int totalCount = freeDao.selectCntAll();
		
		// �럹�씠吏� 媛앹껜 �깮�꽦
		Paging paging = new Paging(totalCount, curPage);
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
				items = upload.parseRequest((RequestContext) req);
				
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
					board.setFree_board_writer((String) req.getSession().getAttribute("member_id"));
					
				} else {
					UUID uuid = UUID.randomUUID();
					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
					System.out.println(u);
					// -----------------
					
					//濡쒖뺄 ���옣�냼 �뙆�씪
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
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

	
}
