package com.example.spring.db.dao;

import java.util.List;

import com.example.spring.db.model.Foo;

public interface IFooService {

	List<Foo> findAll();
	
}
