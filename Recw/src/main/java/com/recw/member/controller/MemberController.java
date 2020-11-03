package com.recw.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

	@RequestMapping(value = "terms")
	public String terms() {

		return "/member/terms";
	}

	@RequestMapping(value = "login")
	public String login() {

		return "/member/login";
	}
	@RequestMapping(value = "loginProc", method = RequestMethod.POST)
	public ModelAndView loginProc(MemberVO vo) {
		System.out.println(vo.getEmail() + vo.getPassword());
		System.out.println(service.login_Member(vo));
		return new ModelAndView("/", "list", service.login_Member(vo));
	}

	@RequestMapping(value = "joinView")
	public String joinView(MemberVO vo) {
		return "/member/join";
	}

	@RequestMapping(value = "joinProc", method = RequestMethod.POST)
	public String joinReg(MemberVO vo) {

		int result = service.reg_Member(vo);
		if (result > 0) {
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "checkEmail", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int checkEmail(MemberVO vo) {
		return service.checkEmail(vo);
	}
	
	@RequestMapping(value = "checkNick", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int checkNick(@RequestParam("nickname") String nickname) {
		return service.checkNick(nickname);
	}


}
