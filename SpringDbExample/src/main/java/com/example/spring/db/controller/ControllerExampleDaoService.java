package com.example.spring.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.db.dao.FooCrudRepository;

@Service
public class ControllerExampleDaoService {

	@Autowired
	private FooCrudRepository service;

	public String test() {
		service.findAll().forEach(System.out::println);
		return "test";
	}

	public String usingTest() {
		return test();
	}

}