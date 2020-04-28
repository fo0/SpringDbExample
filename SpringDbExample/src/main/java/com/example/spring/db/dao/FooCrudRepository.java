package com.example.spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.db.model.Foo;


@Repository
public interface FooCrudRepository extends CrudRepository<Foo, Long>{

}
