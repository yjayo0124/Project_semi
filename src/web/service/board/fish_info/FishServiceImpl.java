package web.service.board.fish_info;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.fish_info.FishDao;
import web.dao.board.fish_info.FishDaoImpl;
import web.dto.FishInfo;
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
	public void write(HttpServletRequest req) {
		
		FishInfo fishInfo = null ;
		
		fishInfo = new FishInfo() ;
		
		fishInfo.setFish_name( req.getParameter( "fish_name" ));
		fishInfo.setFish_type( req.getParameter( "fish_type" ));
		fishInfo.setFish_sesson( req.getParameter( "fish_sesson" ));
		fishInfo.setFish_min_length( req.getParameter( "fish_min_length" ));
		fishInfo.setFish_care( req.getParameter( "fish_care" ));
		fishInfo.setFish_content( req.getParameter( "fish_content" ));
		fishInfo.setMember_id( (String)req.getSession().getAttribute( "member_id" ) ) ;
			
		fishDao.insert(fishInfo);
		
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
	public void update(HttpServletRequest req) {
		
		FishInfo fishInfo = null ;
		
		fishInfo = new FishInfo() ;
		
		fishInfo.setFish_no( Integer.parseInt(req.getParameter( "fish_no" ) ) ) ;
		fishInfo.setFish_name( req.getParameter( "fish_name" ));
		fishInfo.setFish_type( req.getParameter( "fish_type" ));
		fishInfo.setFish_sesson( req.getParameter( "fish_sesson" ));
		fishInfo.setFish_min_length( req.getParameter( "fish_min_length" ));
		fishInfo.setFish_care( req.getParameter( "fish_care" ));
		fishInfo.setFish_content( req.getParameter( "fish_content" ));
		
		System.out.println( fishInfo );
		fishDao.update(fishInfo);
	
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


	


		
	

}
