package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// 요청 URL : http://localhost:8080/lesson04/ex02/1
	@GetMapping("/lesson04/ex02/1") // @RequestMapping도 가능
	public String ex02_1() {
		return "lesson04/add_student";
	}
	
	// 요청 URL : http://localhost:8080/lesson04/ex02/add_student
	@PostMapping("/lesson04/ex02/add_student")
	public String addStudent(
			// name에 있는 값과 일치하는 필드에 값이 들어간다.
			@ModelAttribute Student student, // 우리가 받으려는 객체 명시
			Model model
	) {
		// db insert
		studentBO.addStudent(student);
		
		// 추가된 학생을 가져와서 Model 객체에 담아둠
		student = studentBO.getStudentById(student.getId());
		
		model.addAttribute("subject", "학생 정보");
		model.addAttribute("result", student);
		
		// 추가된 학생 정보를 나타내는 jsp
		return "lesson04/after_add_student";
	}
}
