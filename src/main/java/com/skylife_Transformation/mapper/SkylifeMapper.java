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

	// 로그인
	public Skylife login(Skylife skylife)throws Exception;

	// 이메일 중복 체크
	public int emailhave(String email);

	// 회원정보 수정
	public void memUpdate(Skylife vo) throws Exception;
	// 회원정보 비밀번호 체크
	public String getPW(Skylife vo) throws Exception;
	// 회원정보 비밀번호 수정
	public void memPWUpdate(Skylife vo) throws Exception;

	// 비밀번호 찾기
	public Skylife findPw(String email) throws Exception;

	// 비밀번호 수정
	public void updatePW(Skylife skylifevo);

	// 아이디 찾기
	public String findID(String email) throws Exception;

	// 회원 삭제
	public boolean delete(String id);
	
}
