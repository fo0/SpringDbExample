package com.example.spring.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.db.model.Foo;

@Service
public class FooService implements IFooService {

	@Autowired
	private FooCrudRepository repository;

	public List<Foo> findAll() {
		return (List<Foo>) repository.findAll();
	}

}
