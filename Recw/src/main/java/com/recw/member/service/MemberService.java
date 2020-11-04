package com.recw.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.recw.member.dao.IMemberDao;
import com.recw.member.vo.MemberVO;

@Service
public class MemberService implements IMemberService {

	@Inject
	private IMemberDao dao;

	/**
	 * 회원 등록
	 */
	@Override
	public int reg_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.reg_Member(vo);
	}

	/**
	 * 회원 정보
	 */
	@Override
	public void read_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원 정보 수정
	 */
	@Override
	public void update_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원 정보 삭제
	 */
	@Override
	public void delete_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원 리스트
	 */
	@Override
	public void list_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 이메일 중복 확인
	 */
	@Override
	public int checkEmail(String email) {
		// TODO Auto-generated method stub
		return dao.checkEmail(email);
	}

	/**
	 * 닉네임 중복 확인
	 */
	@Override
	public int checkNick(String nickname) {
		// TODO Auto-generated method stub
		return dao.checkNick(nickname);
	}

	/**
	 * 로그인
	 */
	@Override
	public boolean login_Member(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		return dao.login_Member(vo, session);
	}

}
