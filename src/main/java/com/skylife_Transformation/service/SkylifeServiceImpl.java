package com.skylife_Transformation.service;

import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.mapper.SkylifeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Service
public class SkylifeServiceImpl implements SkylifeService {

	@Autowired
	private SkylifeMapper mapper;

	// 회원가입
	@Override
	public Skylife register(Skylife skylife) {
		mapper.register(skylife);
		return skylife;
	}

	// 아이디 중복
	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		return result;
	}
}
