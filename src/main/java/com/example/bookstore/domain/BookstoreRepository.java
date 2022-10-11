package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookstoreRepository extends CrudRepository<Bookstore, Long> {

	List<Bookstore> findBytitle(String title);
	
	

}
