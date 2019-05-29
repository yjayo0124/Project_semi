package web.service.board.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Notice;
import web.util.Paging;

public interface NoticeService {

	public List getList(Paging paging);

	public Paging getCurPage(HttpServletRequest req);

	public Notice getNoticeno(HttpServletRequest req);
	
	public Notice viewNotice(Notice notice);
	
	public void writeNotice(HttpServletRequest req);
	
	public void deleteNotice(Notice notice);
	
	public void updateNotice(HttpServletRequest req);
	
	public boolean CheckWriter(HttpServletRequest req);
	
}
