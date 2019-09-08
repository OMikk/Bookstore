package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Book;
import com.example.demo.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Norjan kalat", "Matti Mainio", "2015", "1234", "13,45"));
			repository.save(new Book("Ihmeellinen luonto", "Jorma Jousimies", "2010", "1235", "15,00"));
			
			log.info("fetch all books");
			for (Book book  : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
