package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;

	// 회원가입 화면
	// 요청 URL : http://localhost:8080/lesson04/ex01/1
	@RequestMapping(path="/lesson04/ex01/1", method=RequestMethod.GET) // 모든 메소드(get, post) 허용
	
	public String ex01() {
		// 절대경로 /WEB-INF/jsp/lesson04/add_user.jsp
		return "lesson04/add_user"; // view 경로 ,,,, 파일 경로
	}
	
	// 405 에러: Request method 불일치
	// 요청 URL : http://localhost:8080/lesson04/ex01/add_user
	@PostMapping("/lesson04/ex01/add_user") // post만 허용
	
	public String add_user(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce
			// required=false =>>>> null 값이 들어올 수 있다
	) {
		// insert DB
		userBO.insertUser(name, yyyymmdd, email, introduce);
		
		// 결과 jsp
		return "lesson04/after_add_user"; // 결과 jsp 경로
		// 파라미터 값이 잘 나왔는지 확인 -> 위에 줄에 break point 걸기
	}
}
