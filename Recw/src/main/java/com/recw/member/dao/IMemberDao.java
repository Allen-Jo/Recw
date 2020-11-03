package com.recw.member.dao;

import java.util.List;

import com.recw.member.vo.MemberVO;

public interface IMemberDao {

	// 회원등록
	public int reg_Member(MemberVO vo);

	// 회원정보보기
	public void read_Member(MemberVO vo);

	// 회원 정보 수정
	public void update_Member(MemberVO vo);

	// 회원 탈퇴
	public void delete_Member(MemberVO vo);

	// 회원 전체 목록
	public void list_Member(MemberVO vo);

	// 이메일 중복 체크
	public int checkEmail(MemberVO vo);

	// 닉네임 중복 체크
	public int checkNick(String nickname);
	
	//로그인
	public List<MemberVO> login_Member(MemberVO vo);

}
