package com.potterinc.auto.controller;

import com.potterinc.auto.dao.Review;
import com.potterinc.auto.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/review")
    public ModelAndView getAllReviews() {
        ModelAndView reviewModel = new ModelAndView("review.html");

        List<Review> reviews = reviewService.getAll();

        reviewModel.addObject("reviews", reviews);

        return reviewModel;
    }
}
