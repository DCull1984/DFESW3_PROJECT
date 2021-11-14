package com.qa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.project.domain.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
