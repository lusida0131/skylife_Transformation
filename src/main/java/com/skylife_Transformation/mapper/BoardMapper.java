package com.skylife_Transformation.mapper;

import java.util.List;

import com.skylife_Transformation.domain.BoardVO;
import com.skylife_Transformation.domain.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
	// 게시글 작성
	public void insert(BoardVO vo);
	
	// 게시글 상세보기
	public BoardVO view(int b_num);
	
	// 게시글 수정
	public void update(BoardVO vo);
	
	// 게시글 삭제
	public void delete(int b_num);
	
	// 게시글 리스트
	public List<BoardVO> list(String vo);
	
	// 게시글 목록(페이징)
	public List<BoardVO> getListWithPaging(Criteria cri);

	// 게시글 총수
	public int getTotalCount(Criteria cri);
	
	
	// 댓글이 추가(amount=+1), 삭제(amount=-1)되면 replyCnt 값을 갱신하는 매소드
	public void updateReplyCnt(@Param("b_num") Integer bno, @Param("amount") int amount);

	// 게시글 조회수
	public boolean increaseViewcnt(int b_num);

}
