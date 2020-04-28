package com.example.spring.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.db.model.Foo;

@Repository
public interface FooJpaRepository extends JpaRepository<Foo, Long> {

}
