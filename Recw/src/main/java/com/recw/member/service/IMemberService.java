package com.recw.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.recw.member.vo.MemberVO;

public interface IMemberService {
	
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
	public int checkEmail(String email);

	// 닉네임 중복 체크
	public int checkNick(String nickname);

	//로그인
	public boolean login_Member(MemberVO vo, HttpSession session);
	
	//이메일 키
//	public void mailSendWithUserKey(String email, String nickname, HttpServletRequest request);
	public void mailSendWithUserKey(MemberVO vo, HttpServletRequest request);
	
	//이메일 확인키
	public int Certified(String email, String key);
}
