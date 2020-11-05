package com.recw.member.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.recw.member.dao.IMemberDao;
import com.recw.member.vo.MemberVO;

@Service
public class MemberService implements IMemberService {

	@Inject
	private IMemberDao dao;

	@Inject
	public JavaMailSender mailSender;

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

	/**
	 * 이메일 인증키 난수 생성  메서드
	 * @return
	 */
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	/**
	 * 난수키 생성
	 */
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	/**
	 * 인증 메일 발송
	 * getKey 난수키 생성
	 * createMimeMessage 메일 생성
	 * 
	 */
	@Override
	public void mailSendWithUserKey(MemberVO vo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String email = vo.getMem_email();
		String nickname = vo.getMem_nickname();

		String key = getKey(false, 20);
		vo.setMem_key(key);
		dao.GetKey(vo);

		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>부동상 커뮤니티 인증메일입니다.</h2><br><br>" + "<h3>" + nickname + "님</h3>"
				+ "<p>인증하기 버튼을 누르시면 이메일 인증이 완료됩니다. : " + "<a href='http://localhost:8080" + request.getContextPath()
				+ "/member/Certified?Mem_email=" + email + "&Mem_key=" + key + "'>인증하기</a></p>";
		try {
			mail.setSubject("[본인인증] 부동산 커뮤니티 인증 메일", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 메일 인증 메서드 인증 되면 'Y' 변경
	 */
	@Override
	public int Certified(String email, String key) {

		int resultCnt = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_email", email);
		map.put("mem_key", key);

		resultCnt = dao.alter_userKey(map);

		return resultCnt;
	}
}
