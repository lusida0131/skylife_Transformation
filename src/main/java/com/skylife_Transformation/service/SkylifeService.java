package com.skylife_Transformation.service;


import com.skylife_Transformation.domain.Skylife;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SkylifeService {
	
	// 회원가입
	public Skylife register(Skylife skylife);
	
	// 아이디 중복체크
	public int idCheck(String id);

	// 로그인
	public Skylife Login(Skylife id)throws Exception;

	// 이메일 중복체크
	public int emailhave(String email);

	// 회원 수정
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
	public String findID(HttpServletResponse response, String email) throws Exception;

	// 회원 삭제
	public boolean remove(String id);

}
