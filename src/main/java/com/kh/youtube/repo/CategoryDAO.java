package com.kh.youtube.repo;

import com.kh.youtube.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {


}
