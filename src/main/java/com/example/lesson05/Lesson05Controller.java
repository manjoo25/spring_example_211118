package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Controller {

	// 요청 URL : http://localhost:8080/lesson05/ex01
	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	// 요청 URL : http://localhost:8080/lesson05/ex02
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model) {
		// String 리스트
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("멜론");
		fruits.add("포도");
		fruits.add("딸기");
		fruits.add("망고");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "김승주");
		userMap.put("age", 25);
		userMap.put("hobby", "독서");
		users.add(userMap);
		
		userMap = new HashMap<>();
		userMap.put("name", "신바다");
		userMap.put("age", 4);
		userMap.put("hobby", "그루밍");
		users.add(userMap);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	// 요청 URL : http://localhost:8080/lesson05/ex03
	@RequestMapping("/lesson05/ex03")
	
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
	}
	
	// 요청 URL : http://localhost:8080/lesson05/ex04
		@RequestMapping("/lesson05/ex04")
		
		public String ex04(Model model) {
			return "lesson05/ex04";
		}
	
}
