package com.example.baseball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseballApplication {


	/*
	 *  このメインメソッドが、アプリのエントリーポイントとなり、Springアプリを起動している。
	 *  このパッケージと同じところに、ソースファイルを配置する
	 */
	public static void main(String[] args) {
		SpringApplication.run(BaseballApplication.class, args);
	}
}
