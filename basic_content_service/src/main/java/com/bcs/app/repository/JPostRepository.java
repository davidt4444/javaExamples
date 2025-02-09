package com.bcs.app.repository;

import com.bcs.app.model.JPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPostRepository extends JpaRepository<JPost, Integer> {
}