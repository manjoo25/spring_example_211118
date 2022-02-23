package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private ReviewBO reviewBO;
	// 요청 URL : http://localhost:8080/lesson03/ex03?id=23&review=역시 맛있다!!
	@RequestMapping("/lesson03/ex03")
	
	public String ex03(
			@RequestParam(value="id") int id,
			@RequestParam(value="review") String review
	) {
		int row = reviewBO.updateReviewById(id, review);
		return "변경 완료 : " + row;
	}
}
