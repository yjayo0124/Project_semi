package web.dao.board.fish_info;

import web.dto.FishInfoFile;
import web.dto.festival.FestivalFile;

public interface FishFileDao {

	//파일 업로드 기록 삽입
	public void insert( FishInfoFile fishInfoFile );
	
	
	//특정 boardno로 파일 조회
	public FishInfoFile selectByBoardno( FishInfoFile fishInfoFile ) ;
	
	public void updateFile ( FishInfoFile fishInfoFile );
	
	public void delete ( FishInfoFile fishInfoFile );
	
	public void deleteWithoutInsert(FishInfoFile fishInfoFile );
}
