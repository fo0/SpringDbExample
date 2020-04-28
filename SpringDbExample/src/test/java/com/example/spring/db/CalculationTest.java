package com.example.spring.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.db.dao.FooCrudRepository;
import com.example.spring.db.model.Foo;

@SpringBootTest
public class CalculationTest {

	@Autowired
	private FooCrudRepository db;

	@Test
	public void test() {
		db.save(Foo.builder().build());
		assertEquals(true, db.count() > 0);
	}

}
