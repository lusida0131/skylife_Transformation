package com.skylife_Transformation.controller;

import javax.servlet.http.HttpSession;

import com.skylife_Transformation.domain.PubVO;
import com.skylife_Transformation.service.PubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.AllArgsConstructor;

@Controller
@Slf4j
@RequestMapping("/pub/*")
@AllArgsConstructor
public class PubController {

	private PubService service;
	
	// 공지사항 목록
	@GetMapping("/public")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.list());
	}
	
	// 공지사항 등록
	@GetMapping("/register")
	public void register() {	
	}

	// 공지사항 기능
	@PostMapping("/register")
	public String register(PubVO pub, RedirectAttributes rttr) {
		log.info("register: " + pub);
		service.register(pub);
		rttr.addFlashAttribute("result", pub.getPno());
		return "redirect:/pub/public";
	}
	
	// 공지사항 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") Integer pno, RedirectAttributes rttr) {
		log.info("remove..." + pno);
		if(service.remove(pno)) {
			rttr.addFlashAttribute("result","success");
		} else {
			System.out.println("remove failed");
		}
		return "redirect:/pub/public";
	}
	
	// 공지사항 삭제
	@GetMapping("/remove")
	public void get12(@RequestParam("pno") Integer pno, Model model) {
		log.info("/remove : remove click");
		model.addAttribute("pub", service.get(pno));
	}
	
	// 공지사항 수정
	@PostMapping("/modify")
	public String modify(PubVO pub, RedirectAttributes rttr) {
		log.info("modify : modify complete click " + pub);
		
		if(service.modify(pub)) { //구현이 되었는지 확인
			rttr.addFlashAttribute("result","success");
		} else {
			System.out.println("modify failed");
		}
		
		return "redirect:/pub/public";
	}
	
	// 공지사항 수정
	@GetMapping("/modify")
	public void get(@RequestParam Integer pno, Model model) {
		log.info("/modify : modify click");
		model.addAttribute("pub", service.get(pno));
	}
	
}
