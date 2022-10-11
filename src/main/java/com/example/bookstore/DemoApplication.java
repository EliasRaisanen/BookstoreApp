package com.example.bookstore;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Bookstore;
import com.example.bookstore.domain.BookstoreRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;


@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookstoreRepository repository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		log.info("save categories");
		
		
		
		crepository.save(new Category("Horror"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Comedy"));
		
		
		User user1 = new User("user", "$2a$12$ltduSjP6fIBr9fD1J4/RFOb58z/ZSnGoo2JxrPjpRADsHQ/4T6Yoq\n", "j@ggg.com", "USER");
		User user2 = new User("admin", "$2a$12$yBVg9zTtD6bPwQIx7iXtAOy8G2ACM1F/i2rRx6nKnbVvJ.Gh2QibK", "h@ggg.com", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		repository.save(new Bookstore("NallePuh", "Taavi", "jjj", "2000", "10", crepository.findByName("Horror").get(0)));
		repository.save(new Bookstore("Tiikeri", "Taavi", "hhh", "2012", "100", crepository.findByName("Fantasy").get(0)));
		repository.save(new Bookstore("Nasu", "Jari", "ggg", "2020", "15", crepository.findByName("Comedy").get(0)));
		
		log.info("fetch all books");
		for (Bookstore book : repository.findAll()) {
			log.info(book.toString());
		}
	};
	}

}
