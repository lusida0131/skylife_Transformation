package com.skylife_Transformation.controller;

import java.util.List;
import com.skylife_Transformation.domain.*;
import com.skylife_Transformation.service.BoardService;
import com.skylife_Transformation.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardservice;

	private final ReplyService replyservice;

	// 게시글 리스트
	@GetMapping("/board")
	public void boardList(Criteria cri, Model model) {
		log.info("list={}", cri);
		model.addAttribute("list", boardservice.list(cri));	// 게시글 목록
		// 페이징 처리를 위해 PageDTO 객체를 전달 -> jsp 페이지에서 페이징 처리를 한다.
		int total = boardservice.getTotal(cri);
		log.info("total={} " , total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	// 게시글 작성
	@GetMapping("/boardWrite")
	public String write(Skylife vo) {
		log.info("board write button click");
		return "/board/boardWrite";
	}
	// 게시글 작성
	@PostMapping("/boardWrite")
	public String write(@ModelAttribute BoardVO vo) {
		boardservice.insert(vo);
		log.info("write success={} " , vo);
		return "redirect:/board/board";
	}
	
	// 게시글 조회
	@GetMapping("/boardView")
	public String view1(Model model, Criteria cri, @RequestParam int b_num) throws Exception {
		// 조회수
		boardservice.increaseViewcnt(b_num);
		BoardVO data = boardservice.view(b_num);
		model.addAttribute("data", data);
		log.info("board: " + data);
		
		List<ReplyVO> replyData = replyservice.selectcomment(cri, b_num);
		model.addAttribute("replyData", replyData);
		log.info("reply: " + replyData);;

		return "/board/boardView";
	}
		

	// 게시글 수정 폼
	@GetMapping("/update")
	public void updatePage(@RequestParam Integer b_num,  Model model) throws Exception {
		model.addAttribute("blist", boardservice.view(b_num));
	}
	
	// 게시글 수정 (기능)
	@PostMapping("/update")
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		log.info("board update success");
		boardservice.update(vo);
		log.info("update success: " + vo);
		
		return "redirect:/board/board";
	}
	
	// 게시글 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int b_num) throws Exception {
		boardservice.delete(b_num);
		return "redirect:/board/board";
	}
}