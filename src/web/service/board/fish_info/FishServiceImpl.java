package web.service.board.fish_info;

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

import web.dao.board.fish_info.FishDao;
import web.dao.board.fish_info.FishDaoImpl;
import web.dao.board.fish_info.FishFileDao;
import web.dto.BuyBoard;
import web.dto.BuyFile;
import web.dto.FishInfo;
import web.dto.FishInfoFile;
import web.dto.FreeBoard;
import web.dto.festival.FestivalBoard;
import web.util.Fish_Paging;
import web.util.Paging;

public class FishServiceImpl implements FishService {

	private FishDao fishDao = new FishDaoImpl() ;

	@Override
	public List getList(Fish_Paging paging) {
		return fishDao.selectAll(paging) ;
	}

	@Override
	public Fish_Paging getCurPage(HttpServletRequest req) {
		// 전달파라미터 curPage 파싱
				String param = req.getParameter("curPage");
				int curPage = 0;
				if( param!=null && !"".equals(param) ) {
					curPage = Integer.parseInt(param);
				}
				
				// 전체 게시글 수
				int totalCount = fishDao.selectCntAll();
				
				// 페이징 객체 생성
				Fish_Paging paging = new Fish_Paging(totalCount, curPage);
//				System.out.println(paging); //TEST
				
				return paging;
	}

	@Override
	public FishInfo getBoardno(HttpServletRequest req) {
		
		String param = req.getParameter("fish_no");
		int boardno = 0;
		if(param!=null && !"".contentEquals(param)) {
			boardno = Integer.parseInt(param);
		}
		FishInfo fishInfo = new FishInfo() ;
		fishInfo.setFish_no( boardno ) ;
		return fishInfo;
		
	}
	
	@Override
	public FishInfo view(FishInfo fishInfo) {
		return fishDao.selectBoardByBoardno(fishInfo) ;
	}


	
		@Override
		public boolean checkWriter(HttpServletRequest req) {

		String loginId = (String) req.getSession().getAttribute("member_id");
		
		FishInfo fishInfo = getBoardno(req) ;
		
		fishInfo = fishDao.selectBoardByBoardno(fishInfo) ;
		
		if( !loginId.equals(fishInfo.getMember_id())) {
			return false;
		}
		
		return true;
	}



	@Override
	public void delete(FishInfo fishInfo) {
		fishDao.delete(fishInfo) ;
		
	}

	@Override
	public HashMap getPrevNext(FishInfo fishInfo) {
		return fishDao.getPrevNext(fishInfo);
	}

	@Override
	public HashMap getPrevNextName(FishInfo fishInfo) {
		return fishDao.getPrevNextName(fishInfo);
	}

	@Override
	public void write(FishInfo fishInfo) {
		fishDao.insert(fishInfo);
		
	}

	@Override
	public void update(FishInfo fishInfo) {
		fishDao.update(fishInfo);
		
	}

	@Override
	public int getBoardNo() {
		return fishDao.selectBoardno();
	}


	


		
	

}
