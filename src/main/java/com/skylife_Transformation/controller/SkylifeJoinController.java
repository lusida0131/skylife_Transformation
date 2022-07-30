package com.skylife_Transformation.controller;


import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.mapper.SkylifeMapper;
import com.skylife_Transformation.service.SkylifeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Random;

@Controller
@Slf4j
@RequestMapping(value = "/auth")
public class SkylifeJoinController {

	private JavaMailSender mailSender;

	private SkylifeService service;

//	private KakaoService kakaoService;

//	private SkylifeMapper skylifeMapper;

	// 약관동의 폼
	@GetMapping("/joinAgree")
	public String joinAgree() {
		return "/auth/joinAgree";
	}
	
	// 회원 가입 폼
	@GetMapping("/joinForm")
	public String joinForm() {
		return "/auth/joinForm";
	}

	// 회원 가입 폼
	@PostMapping("/joinForm")
	public String joinForm(Skylife skylife, RedirectAttributes rttr) {
		service.register(skylife);
		rttr.addFlashAttribute("msg", "REGISTERED");
		return "redirect:/auth/loginForm";
	}
	
	// 로그인 폼
	@GetMapping("/loginForm")
	public String login() {
		return "/auth/loginForm";
	}

	// 로그인 폼
	@PostMapping("/loginForm")
	public String loginForm(HttpSession session, Skylife skylife) throws Exception {
		Skylife user = service.Login(skylife);
		if (user != null && BCrypt.checkpw(skylife.getPw(), user.getPw())) {
			session.setAttribute("user", user);
			return "redirect:/";
		} else {
			return "redirect:/auth/loginForm";
		}
	}
	
	// 로그아웃 auth
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception {
    	log.info("logout user: " + session.getAttribute("user"));
		session.invalidate();

		return "redirect:/";
	}

	// 아이디 중복 체크 auth
	@GetMapping("/idCheck")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		int result = service.idCheck(id);
		return Integer.toString(result);
	}

	//***************** 이메일 중복체크 ********************** auth
	@GetMapping("/emailhave")
	@ResponseBody
	public String emailhave(HttpServletRequest request) {
		String email = request.getParameter("email");
		return Integer.toString(service.emailhave(email));
	}
	//auth
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("auth/index : ");
		return "/";
	}

	// 회원 가입 이메일 전송
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		/* 난수 생성 */
//		Random random = new Random();
//		int checkNum = random.nextInt(888888) + 111111;
//		log.info("인증번호" + checkNum);
//
//		/* 메일 보내기 */
//		String setFrom = "sktlifemailsender@gmail.com";
//		String toMail = email;
//		String title = "회원가입 인증메일입니다.";
//		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
//				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//		try {
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//			helper.setFrom(setFrom);
//			;
//			helper.setTo(toMail);
//			helper.setSubject(title);
//			helper.setText(content, true);
//			mailSender.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Integer.toString(checkNum);
		return service.mailCheckGET(email);
	}

	// 회원 수정폼
	@GetMapping("/memUpdate")
	public String memUpdateView() throws Exception {
		return "/auth/memUpdate";
	}

	// 회원 수정 기능 auth
	@PostMapping("/memUpdate")
	public String memUpdate(Skylife vo, HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		log.info("memUpdate vo: " + vo);
		if(BCrypt.checkpw(vo.getPw(), service.getPW(vo)) != true) {		// 입력된 현재비밀번호 pw1과 db현재비밀번호 비교 : 비밀번호가 다르므로 돌려보냄
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('정보가 맞지 않습니다.'); </script>");
	        out.flush();
			return "/auth/memView";
		}

		service.memUpdate(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		session.invalidate();

		return "redirect:/";
	}

	// 회원 정보 중 비밀번호 수정 기능
	@GetMapping("/memPWUpdate")
	public String memPWUpdate() {
		return "/auth/memPWUpdate";
	}

	// 회원 정보 중 비밀번호 수정 기능 auth
	@PostMapping("/memPWUpdate")
	public String memPWUpdate(HttpServletRequest request, HttpServletResponse response, Skylife vo, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		log.info("memPWUpdate >>> pw1: " + request.getParameter("pw1") + " pw2: " + request.getParameter("pw2"));
		String pw1 = request.getParameter("pw1");

		if(BCrypt.checkpw(pw1, service.getPW(vo)) != true) {		// 입력된 현재비밀번호 pw1과 db현재비밀번호 비교 : 비밀번호가 다르므로 돌려보냄
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('정보가 맞지 않습니다.'); </script>");
	        out.flush();
			return "/auth/memView";
		}

		String hashedPw = BCrypt.hashpw(request.getParameter("pw2"), BCrypt.gensalt());
		vo.setPw(hashedPw);
		service.memPWUpdate(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		session.invalidate();

		return "redirect:/";
	}

	// 회원 탈퇴 auth
	@GetMapping("/memRemove")
	public String remove1(@RequestParam("id") String id, HttpSession session, RedirectAttributes rttr) {
		log.info("remove...", id);
		if (service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			log.error("remove failed");
		}
		session.invalidate();
		return "redirect:/";
	}

	///////////////////////////////////////////////////////////
	// 아이디/비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw() throws Exception {
		return "/auth/findPw";
	}

	// 임시 비밀번호 전송 폼 auth
	@GetMapping("page/emailPW")
	@ResponseBody
	public String FindEmail(String email, Skylife vo, RedirectAttributes redirectAttributes) throws Exception {
		/* 난수 생성 */
		Random random = new Random();
		int newPW = random.nextInt(888888) + 111111;
		log.info("임시 비밀번호={}" , newPW);

		/* 메일 보내기 */
		String setFrom = "SkyLifeKorea@gmail.com";
		String toMail = email;
		String title = "[SkyLife] 비밀번호변경 인증 이메일 입니다";
		String content = "안녕하세요. 회원님 홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "임시 비밀번호는 " + newPW + "입니다." + "<br>"
				+ "해당 임시번호로 인증번호 로그인하여 비밀번호를 변경해주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			;
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nPass = Integer.toString(newPW);
		/////////////////////// 비밀번호 변경//////////////////////////
		log.info("임시 비밀번호로 변경");
		String changePW = BCrypt.hashpw(nPass, BCrypt.gensalt());
		vo.setPw(changePW);
		service.updatePW(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		///////////////////////////////////////////////////////////
		return nPass;
	}

	// 아이디 찾기
	@GetMapping("/findID")
	public String findID() throws Exception {
		return "/auth/findID";
	}

	// 아이디 찾기
	@PostMapping("/getID")
	public String getID(HttpServletResponse response, @RequestParam String email, Model md) throws Exception {
		md.addAttribute("id", service.findID(response, email));
		return "/auth/getID";
	}
}