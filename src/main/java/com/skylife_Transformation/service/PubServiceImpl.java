package com.skylife_Transformation.service;

import java.util.List;
import com.skylife_Transformation.domain.PubVO;
import com.skylife_Transformation.mapper.PubMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Slf4j
@Service
@AllArgsConstructor
public class PubServiceImpl implements PubService{

	@Autowired
	private PubMapper mapper;
	
	// 공지사항 등록
	@Override
	public void register(PubVO pub) {
		log.info("register..." + pub);
		mapper.insert(pub);
	}
	
	// 공지사항 수정
	@Override
	public boolean modify(PubVO pub) {
		log.info("modify..." + pub);
		return mapper.update(pub) == 1;
	}
	
	// 공지사항 삭제
	@Override
	public boolean remove(Integer pno) {
		log.info("remove..." + pno);
		return mapper.delete(pno) == 1;
	}
	
	// 공지사항 목록
	@Override
	public List<PubVO> list() {
		log.info("getList...");
		return mapper.list();
	}
	
	// 공지사항 뷰
	 @Override 
	 public PubVO get(Integer pno) {
	      log.info("public num: " + pno);
	      return mapper.read(pno);
	   }
}
