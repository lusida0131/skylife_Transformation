package com.skylife_Transformation.mapper;
import com.skylife_Transformation.domain.Skylife;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface SkylifeMapper {
	
	// 회원가입
	public void register(Skylife skylife);
	
	// 아이디 중복 체크
	public int idCheck(@Param("id") String id);
	

	
}
