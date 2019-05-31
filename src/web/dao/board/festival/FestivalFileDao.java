package web.dao.board.festival;

import web.dto.festival.FestivalFile;

public interface FestivalFileDao {
	
	//파일 업로드 기록 삽입
		public void insert(FestivalFile board);
		
		
		//특정 boardno로 파일 조회
		public FestivalFile selectByBoardno(FestivalFile board);
		
		public void delete (FestivalFile board);
		

}
