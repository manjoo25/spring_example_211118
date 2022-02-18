package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// view를 내릴 때는 @ResponseBody이 없다.
public class Lesson01Ex02Controller {

	// 요청 URL : http://localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02_1() { // 경로에 대한 string
		// ResponseBody가 아닌 상태로 String을 리턴하면
		// ViewResolver에 의해서 리턴된 String 이름이 view를 찾고 view 화면이 구성된다.
		
		return "lesson01/ex02"; // jsp view 경로와 이름 "WEB-INF"부터 써주는데
								// preffix suffix를 제외한 경로를 써준다(이미 설정되어있는 것)
	}
}
