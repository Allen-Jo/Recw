package com.recw.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.recw.member.dao.MemberDao;
import com.recw.member.vo.MemberVO;

@Service
public class MemberService implements IMemberService {
	
	@Inject
	private MemberDao dao;

	@Override
	public void memberRegister(MemberVO member) {
		// TODO Auto-generated method stub
		
	}
	


}
