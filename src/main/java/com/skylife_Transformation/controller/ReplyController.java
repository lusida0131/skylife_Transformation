package com.skylife_Transformation.controller;

import java.util.List;
import com.skylife_Transformation.domain.Criteria;
import com.skylife_Transformation.domain.ReplyPageDTO;
import com.skylife_Transformation.domain.ReplyVO;
import com.skylife_Transformation.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@Slf4j
@AllArgsConstructor
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	// 댓글 페이징
	@GetMapping(value = "/replies/pages/{b_num}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page, @PathVariable("b_num") Integer b_num) {

		log.info("getList............");
		Criteria cri = new Criteria(page, 10);
		log.info(String.valueOf(cri));
		
		return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, b_num), HttpStatus.OK);
	}
	
	// 댓글 등록
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	@ResponseBody
	public String comment(ReplyVO vo) {
		log.info("vo=" + vo);
		String result = null;
		service.comment(vo);
		result="order";
		return result;
	}
	
	// 댓글 삭제
	@RequestMapping(value="/reply/delete/{r_num}")
    public ResponseEntity<String> replyDelete(@PathVariable("r_num") Integer r_num){
       
		log.info("r_num 값 : " + r_num);
		ResponseEntity<String> entity = null;
        try {
            service.delete(r_num);
            // 댓글 삭제가 성공하면 성공 상태메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 삭제가 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 HTTP 상태 메시지 리턴
        return entity;
    }
	
	// 댓글 수정
	@RequestMapping(value="/replies/update", method=RequestMethod.POST) //댓글 수정  
    @ResponseBody
    private int mCommentServiceUpdateProc(@RequestParam int r_num, @RequestParam String r_content) throws Exception{
		
		
        ReplyVO comment = new ReplyVO();
        comment.setR_num(r_num);
        comment.setR_content(r_content);
        return service.update(comment);
    }
}
	
