package com.skylife_Transformation.service;


import com.skylife_Transformation.domain.Skylife;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SkylifeService {
	
	// 회원가입
	public Skylife register(Skylife skylife);
	
	// 아이디 중복체크
	public int idCheck(String id);

}
