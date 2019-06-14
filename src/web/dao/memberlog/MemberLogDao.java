package web.dao.memberlog;

import java.util.List;

import web.dto.LoginLog;
import web.util.Paging;

public interface MemberLogDao {

	public int selectCntAll(String search, LoginLog log);

	public List selectAll(Paging paging, LoginLog log);

	public void insertLog(LoginLog log);


}
