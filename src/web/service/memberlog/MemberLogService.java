package web.service.memberlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.LoginLog;
import web.util.Paging;

public interface MemberLogService {

	public Paging getCurPage(HttpServletRequest req);

	public List getList(Paging paging, LoginLog log);

	public void insertLoginLog(LoginLog log);
}
