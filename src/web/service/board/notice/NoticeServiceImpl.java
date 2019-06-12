package web.service.board.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.notice.NoticeDao;
import web.dao.board.notice.NoticeDaoImpl;
import web.dto.Notice;
import web.util.Paging;

public class NoticeServiceImpl implements NoticeService{

	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public List getList(Paging paging) {
	
		return noticeDao.selectAll(paging);
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		// �����Ķ���� curPage �Ľ�
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
						
		//�˻���
		String search = (String)req.getParameter("search");
				
		// ��ü �Խñ� ��
		int totalCount = noticeDao.selectCntAll(search);
						
		// ����¡ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
//		System.out.println(paging); //TEST
				
		return paging;
	}

	@Override
	public Notice getNoticeno(HttpServletRequest req) {
		
		// �����Ķ���ͷ� �������׹�ȣ ��������
		String param = req.getParameter("notice_no");
		int notice_no = 0;
		if( param!=null && !"".equals(param) ) {
			notice_no = Integer.parseInt(param);
		}
		
		//�������� ��ü ����
		Notice notice = new Notice();
		notice.setNotice_no(notice_no);
		
		//�Ķ���ͷ� ���� ��ȣ �����ͼ� ��ü�� ��� �װ� return
		return notice;
		
	}

	@Override
	public Notice viewNotice(Notice notice) {
		
		//�������� ��ȸ�� +1
		noticeDao.updateHit(notice);
		
		//�Խñ� ��ȸ ��ȯ ���޼ҵ�
		return noticeDao.selectNoticeByNoticeno(notice);
		
		
		
	}

	@Override
	public void writeNotice(HttpServletRequest req) {
		
		//�������� ��ü ����
		Notice notice = new Notice();
		
		String notice_writer = (String) req.getSession().getAttribute("member_nick");  //���ǰ�ü���� �г��Ӱ����ͼ� �������� �۾��̿� �ְ�
		String notice_writer_id = (String) req.getSession().getAttribute("member_id"); //���ǰ�ü���� id�����ͼ� ���������� �� ��� id�� �ִ´�.
		//parameter�� ���� ���� �� ��ü�� �ִ´�
		notice.setNotice_no(noticeDao.selectNoticeno());
		notice.setNotice_title(req.getParameter("notice_title"));
		notice.setNotice_writer(notice_writer); //�۾� �г���
		notice.setNotice_content(req.getParameter("notice_content"));
		notice.setMember_id(notice_writer_id); //�۾���� id
		
		
		//���� ���� ��ü�� insert�޼ҵ�� ������.
		noticeDao.insert(notice);
		
		
		
	}

	@Override
	public void deleteNotice(Notice notice) {
		
		
		noticeDao.delete(notice);
		
		
	}

	@Override
	public void updateNotice(Notice notice) {
		
		
		
		noticeDao.update(notice);
		
		
		
	}

	@Override
	public boolean CheckWriter(String writer, HttpServletRequest req) {

		String loginId = null;
		
		 loginId = (String) req.getSession().getAttribute("member_id");
		
		if( !loginId.equals(writer)) {
			
			return false;	
		} 
		
		return true;
	

	}
	

}
