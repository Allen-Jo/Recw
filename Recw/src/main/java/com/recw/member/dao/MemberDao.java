package com.recw.member.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.recw.member.vo.MemberVO;

@Repository
public class MemberDao implements IMemberDao {

	@Inject
	private SqlSessionFactory factory;

	private static String namespace = "com.recw.mapper.MemberMapper";
	private int n = 0;

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

	@Override
	public void read_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete_Member(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list_Member(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public int checkEmail(MemberVO vo) {

		return factory.openSession().selectOne(namespace + ".checkEmail", vo);
	}

	@Override
	public int checkNick(String nickname) {
		// TODO Auto-generated method stub
		int result = factory.openSession().selectOne(namespace + ".checkNick", nickname);
		return result;
	}

	@Override
	public List<MemberVO> login_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		return factory.openSession().selectOne(namespace+".loginMemver", vo);
		
	}

}
