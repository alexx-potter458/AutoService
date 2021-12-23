package com.potterinc.auto.service;

import com.potterinc.auto.dao.Review;
import com.potterinc.auto.dao.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewDAO;

    public List<Review> getAll() {
        return reviewDAO.getAll();
    }

}
