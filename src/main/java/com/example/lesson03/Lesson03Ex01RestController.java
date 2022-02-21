package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// 요청 URL : http://localhost:8080/lesson03/ex01
	// 요청 URL : http://localhost:8080/lesson03/ex01?id=숫자
	@RequestMapping("/lesson03/ex01")
	public Review ex01( // request 파라미터 , id는 필수 파라미터
			// 필수 파라미터를 받는 방식
			// @RequestParam(value="id") int id
			// @RequestParam(value="id", required=true) int id // 필수 파라미터
			// @RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			@RequestParam(value="id", required = false, defaultValue="1") int id // 비필수 파라미터, 기본값 1 => 1번 데이터의 값을 넘겨주도록
	){
		System.out.println("######## id:" + id);
		return reviewBO.getReview(id);
	}
}
