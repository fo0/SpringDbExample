package com.example.spring.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class DBProxy {

	@Autowired
	private FooCrudRepository foo;

}
