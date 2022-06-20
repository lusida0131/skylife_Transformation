package com.skylife_Transformation.service;

import java.util.ArrayList;
import java.util.List;

import com.skylife_Transformation.domain.Criteria;
import com.skylife_Transformation.domain.ReplyPageDTO;
import com.skylife_Transformation.domain.ReplyVO;
import com.skylife_Transformation.mapper.BoardMapper;
import com.skylife_Transformation.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper boardmapper;
	
	// 댓글 등록
	@Override
	public void comment(ReplyVO vo) {
		mapper.comment(vo);    
	}
	
	// 댓슬 목록(페이징)
	@Override
	public List<ReplyVO> selectcomment(Criteria cri, int vo) {
		return mapper.getListWithPaging(cri,vo);
	}
	
	// 댓글 삭제
	@Override
	public int delete(int r_num) {
		return mapper.delete(r_num);      
	}
	
	// 댓글 수정
	@Override
	public int update(ReplyVO vo) {
		return mapper.update(vo);   
	}
	
	// 댓글 목록(페이징)
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Integer b_num) {
		// page -1일 경우 처리를 해주어야 한다. -> 댓글의 수와 빈 목록을 반환
		if(cri.getPageNum() == -1) {	// 댓글의 수만 필요함
			return new ReplyPageDTO(mapper.getCountByBno(b_num),
					new ArrayList<ReplyVO>());
		} else {
			return new ReplyPageDTO(mapper.getCountByBno(b_num),
					mapper.getListWithPaging(cri, b_num));
		}
	}
}
