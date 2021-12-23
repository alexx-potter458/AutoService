package com.potterinc.auto.dao.impl;

import com.potterinc.auto.dao.Review;
import com.potterinc.auto.dao.ReviewDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<Review> getAll() {

        String reviewQuery = "SELECT * FROM `auto`.`review`";
        Query q = em.createNativeQuery(reviewQuery, Review.class);
        return (List<Review>) q.getResultList();

    }
}
