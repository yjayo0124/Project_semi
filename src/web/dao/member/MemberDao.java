package web.dao.member;

import web.dto.Member;

public interface MemberDao {

	public int selectCntMemberByMemberidAndMemberpw(Member member);

	public Member selectMemberByMemberid(Member member);

}
