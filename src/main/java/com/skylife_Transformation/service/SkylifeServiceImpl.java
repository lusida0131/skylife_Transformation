package com.skylife_Transformation.service;

import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.mapper.SkylifeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Service
public class SkylifeServiceImpl implements SkylifeService {

	@Autowired
	private SkylifeMapper mapper;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// 회원가입
	@Override
	public Skylife register(Skylife skylife) {
		mapper.register(skylife);
		String rawPassword = skylife.getPw();
		String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
		skylife.setPw(encodePassword);
		return skylife;
	}

	// 아이디 중복
	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		return result;
	}
	// 로그인
	@Override
	public Skylife Login(Skylife skylife) throws Exception {
		return mapper.login(skylife);
	}
	// 이메일 중복확인
	@Override
	public int emailhave(String email) {
		int result = mapper.emailhave(email);
		return result;
	}
	// 회원 수정
	@Override
	public void memUpdate(Skylife vo) throws Exception {
		//받은 vo를 mapper로 보내준다.
		mapper.memUpdate(vo);
	}

	// 회원정보 비밀번호 체크
	@Override
	public String getPW(Skylife vo) throws Exception {
		String gp = mapper.getPW(vo);
		return gp;
	}

	// 회원정보 비밀번호 수정
	@Override
	public void memPWUpdate(Skylife vo) throws Exception{
		mapper.memPWUpdate(vo);
	}

	// 비밀번호 찾기
	@Override
	public Skylife findPw(String email) throws Exception {
		return mapper.findPw(email);
	}

	// 비밀번호 수정
	@Override
	public void updatePW(Skylife skylifevo) {
		mapper.updatePW(skylifevo);
	}

	// 아이디 찾기
	@Override
	public String findID(HttpServletResponse response, String email) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = mapper.findID(email);

		if(id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}
	// 회원 삭제
	@Override
	public boolean remove(String id) {
		log.info("remove..." + id);
		return mapper.delete(id);
	}

	@Override
	public String mailCheckGET(String email) {

		return null;
	}


}
