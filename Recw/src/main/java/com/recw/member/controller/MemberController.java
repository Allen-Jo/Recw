package com.recw.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.recw.member.service.IMemberService;
import com.recw.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	IMemberService service;
	Locale locale;

	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		return dateFormat.format(date);
	}

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
		boolean check = service.login_Member(vo, session);
		if (check == true) {
			return "redirect:/";
		} else {
			return "member/login";
		}
	}
	/**
	 * 로그아웃
	 * 
	 * @param session
	 */
	@RequestMapping(value = "logout")
	public void logout(HttpSession session) {
		session.invalidate();
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
	 * 회원가입 기능
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "joinProc", method = RequestMethod.POST)
	public String joinReg(MemberVO vo) {
		int result = service.reg_Member(vo);
		if (result >= 0) {
			return "redirect:/";
		} else {
			return "joinView";
		}
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

//	@RequestMapping(value = "join_succ")
//	public String test() {
//		return "/member/join_succ";
//	}
}
