package com.ads.bcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.bcs.model.JPost;

@Repository
public interface JPostRepository extends JpaRepository<JPost, Integer> {
}