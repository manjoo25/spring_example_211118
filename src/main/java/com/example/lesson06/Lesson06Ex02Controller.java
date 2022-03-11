package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;

	// 회원가입 화면
	// 요청 URL : http://localhost:8080/lesson06/ex02/add_user_view
	@RequestMapping("/lesson06/ex02/add_user_view")
	public String addUserName() {
		return "lesson06/add_user";
	}

	// 중복확인 - ajax 요청
	@ResponseBody
	@RequestMapping("/lesson06/ex02/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		// TODO db 조회
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", userBO.existUserByName(name)); // 중복이면 true 카멜, _ => 정해져있지 않다
		
		return result;
	}
}
