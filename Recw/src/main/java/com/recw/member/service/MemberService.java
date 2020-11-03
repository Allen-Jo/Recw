package com.recw.member.service;


import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.recw.member.dao.IMemberDao;
import com.recw.member.vo.MemberVO;

@Service
public class MemberService implements IMemberService {
	
	@Inject
	private IMemberDao dao;


	@Override
	public int reg_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.reg_Member(vo);
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
	public void delete_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkEmail(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.checkEmail(vo);
	}

	@Override
	public int checkNick(String nickname) {
		// TODO Auto-generated method stub
		return dao.checkNick(nickname);
	}

	@Override
	public List<MemberVO> login_Member(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.login_Member(vo);
	}
	
	
	
	
//	
//	// 이메일 난수 만드는 메서드
//		private String init() {
//			Random ran = new Random();
//			StringBuffer sb = new StringBuffer();
//			int num = 0;
//
//			do {
//				num = ran.nextInt(75) + 48;
//				if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
//					sb.append((char) num);
//				} else {
//					continue;
//				}
//
//			} while (sb.length() < size);
//			if (lowerCheck) {
//				return sb.toString().toLowerCase();
//			}
//			return sb.toString();
//		}
//
//		// 난수를 이용한 키 생성
//		private boolean lowerCheck;
//		private int size;
//
//		public String getKey(boolean lowerCheck, int size) {
//			this.lowerCheck = lowerCheck;
//			this.size = size;
//			return init();
//		}
//
//		// 회원가입 발송 이메일(인증키 발송)
//		public void mailSendWithUserKey(String e_mail, String user_id, HttpServletRequest request) {
//			
//			String key = getKey(false, 20);
//			dao = sqlSession.getMapper(UserDaoInterface.class);
//			dao.GetKey(user_id, key); 
//			MimeMessage mail = mailSender.createMimeMessage();
//			String htmlStr = "<h2>안녕하세요 MS :p 민수르~ 입니다!</h2><br><br>" 
//					+ "<h3>" + user_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
//					+ "<a href='http://localhost:8080" + request.getContextPath() + "/user/key_alter?user_id="+ user_id +"&user_key="+key+"'>인증하기</a></p>"
//					+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
//			try {
//				mail.setSubject("[본인인증] MS :p 민수르님의 인증메일입니다", "utf-8");
//				mail.setText(htmlStr, "utf-8", "html");
//				mail.addRecipient(RecipientType.TO, new InternetAddress(e_mail));
//				mailSender.send(mail);
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}
//			



}
