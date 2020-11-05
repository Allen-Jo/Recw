package com.recw.member.dao;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.recw.member.vo.MemberVO;

@Repository
public class MemberDao implements IMemberDao {

	@Inject
	private SqlSessionFactory factory;

	private static String namespace = "com.recw.mapper.MemberMapper";
	private int n = 0;

	/**
	 * 회원 등록
	 */
	@Override
	public int reg_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		try {
			n = factory.openSession().insert(namespace + ".insertMember", vo);
		} catch (Exception e) {
			// TODO: handle exception
			n = 0;
		}
		return n;
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
	public void delete_Member(MemberVO member) {
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
		int result = factory.openSession().selectOne(namespace + ".checkEmail", email);
		return result;
	}

	/**
	 * 닉네임 중복 확인
	 */
	@Override
	public int checkNick(String nickname) {
		// TODO Auto-generated method stub
		int result = factory.openSession().selectOne(namespace + ".checkNick", nickname);
		return result;
	}

	/**
	 * 로그인 + 세션 저장
	 * check 
	 * 아이디 비밀번호 맞는 계정 개수 카운트값
	 * 1: 성공  0: 실패
	 * mem_Nick 로그인 계정의 닉네임 값 저장
	 * setAttribute 세션에 아이디와 닉네임 저장
	 */
	@Override
	public boolean login_Member(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		String check = factory.openSession().selectOne(namespace+".loginMember", vo);
		if(Integer.parseInt(check)!=0) {
			String mem_Nick = factory.openSession().selectOne(namespace+".viewMember", vo);
			session.setAttribute("mem_email", vo.getMem_email());
			session.setAttribute("mem_nick", mem_Nick);
			
			return true;
		}else {
			return false;
		}
			
		
	}

	/**
	 * 메일 인증키 등록
	 */
	@Override
	public int GetKey(MemberVO vo) {
		// TODO Auto-generated method stub
		return factory.openSession().update(namespace+".getKey", vo);
	}

	/**
	 * 메일 인증 확인
	 */
	@Override
	public int alter_userKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		return factory.openSession().update(namespace+".alterKey", map);
	}

}
