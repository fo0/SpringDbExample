package com.example.spring.db;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.spring.db.dao.DBProxy;

@SpringBootApplication
public class Application {

	@Autowired
	private DBProxy db;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).properties(createProps()).build().run(args);
	}

	private static Properties createProps() {
		Properties p = new Properties();
		return p;
	}

//	@Bean
//	public CommandLineRunner runner() {
//		return args -> {
//			System.out.println("counting foo: " + db.getFoo().count());
//		};
//	}
}
