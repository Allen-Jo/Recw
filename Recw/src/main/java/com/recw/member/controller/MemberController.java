package com.recw.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recw.member.service.IMemberService;
import com.recw.member.service.Sha256;
import com.recw.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	public IMemberService service;

	/**
	 * 약관 화면
	 * 
	 * @return
	 */
	@RequestMapping(value = "terms")
	public String terms() {

		return "/member/terms";
	}

	/**
	 * 로그인 화면
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public String login() {

		return "/member/login";
	}

	/**
	 * 로그인 기능
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "loginProc", method = RequestMethod.POST)
	public String loginProc(MemberVO vo, HttpSession session) {
		
		String encryPassword = Sha256.encrypt(vo.getMem_password());
		vo.setMem_password(encryPassword);
		
		boolean check = service.login_Member(vo, session);
		if (check == true) {
			return "redirect:/";
		} else {
			System.out.println("로그인 실패");
			return "member/login";
		}
	}

	/**
	 * 로그아웃
	 * 
	 * @param session
	 * @return 
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/**
	 * 회원 가입 화면
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "joinView")
	public String joinView(MemberVO vo) {
		return "/member/join";
	}

	/**
	 * 회원가입 + 인증 이메일 
	 * encryPassword 비밀번호 암호화
	 * reg_Member 회원등록 메서드 
	 * mailSendWithUserKey
	 * 메일 인증 메서드
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "joinProc", method = RequestMethod.POST)
	public String joinReg(MemberVO vo, HttpServletRequest request) {

		String encryPassword = Sha256.encrypt(vo.getMem_password());
		vo.setMem_password(encryPassword);

		service.reg_Member(vo);

		service.mailSendWithUserKey(vo, request);

		return "redirect:/";
	}

	/**
	 * 이메일 인증 확인 컨트롤러
	 * @param email
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "Certified", method = RequestMethod.GET)
	public String Certified(@RequestParam("Mem_email") String email, @RequestParam("Mem_key") String key) {

		service.Certified(email, key);

		return "/member/join_succ";
	}

	/**
	 * 이메일 중복 체크
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "checkEmail", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int checkEmail(@RequestParam("email") String email) {
		return service.checkEmail(email);
	}

	/**
	 * 닉네임 중복 체크
	 * 
	 * @param nickname
	 * @return
	 */
	@RequestMapping(value = "checkNick", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int checkNick(@RequestParam("nickname") String nickname) {
		return service.checkNick(nickname);
	}

	/**
	 * 이메일 인증완료
	 * 
	 * @return
	 */
	@RequestMapping(value = "join_succ")
	public String join_succ() {
		System.out.println("MemberController:join_succ: 메일 인증 완료");
		return "/member/join_succ";
	}
}
