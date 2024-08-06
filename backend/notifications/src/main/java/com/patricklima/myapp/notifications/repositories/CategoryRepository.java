package com.patricklima.myapp.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
