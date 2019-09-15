package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.bookstore.demo.Book;
import com.example.bookstore.demo.BookRepository;
import com.example.bookstore.demo.Category;
import com.example.bookstore.demo.CategoryRepository;




@SpringBootApplication
public class BooksApplication {
	private static final Logger log = LoggerFactory.getLogger(BooksApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Nature"));
			crepository.save(new Category("Horror"));
			
			
			repository.save(new Book("Norjan kalat", "Matti Mainio", "2015", "1234", "13.45"));
			repository.save(new Book("Ihmeellinen luonto", "Jorma Jousimies", "2010", "1235", "15.00"));
			
			
			
			
			log.info("fetch all books");
			for (Book book  : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
