package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	// SELECT
	public Review getReview(int id) { // int => 필수 값, Integer => 필수 값x
		// getReviewById ===> where `id`=3
		return reviewDAO.selectReview(id);
	}
	
	// INSERT
	public int addReview(Review review) { // insert 된 행이 몇 개인지 알려준다
		return reviewDAO.insertReview(review);
	}

	// addReviewAsField(11, "콤비네이션R", "신바다", 5.0, "역시 맛있다!!!")
	public int addReviewAsField(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
}