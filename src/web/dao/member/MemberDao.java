package web.dao.member;

import web.dto.MemberDetail;

public interface MemberDao {

	public int selectCntMemberByMemberidAndMemberpw(MemberDetail member);

	public MemberDetail selectMemberByMemberid(MemberDetail member);

	/**
	 * 회원가입
	 * 
	 * @param member - 회원가입 정보
	 */
	public void insert(MemberDetail member);


}
