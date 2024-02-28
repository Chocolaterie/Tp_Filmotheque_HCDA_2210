package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.filmotheque.bll.MovieManager2;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	MovieManager2 movieManager;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testMovies() {
		
		// tester que la liste est vide
		assertEquals(movieManager.getAllMovies().code, "203");
		
		// tester que la liste n'est pas vide
		assertEquals(movieManager.getAllMovies().code, "202");
		
		// tester si erreur
		assertEquals(movieManager.getAllMovies().code, "700");
	}

}
