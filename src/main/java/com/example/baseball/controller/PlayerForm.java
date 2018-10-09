/*
 * このソースの目的は、選手の情報を保存するplayerテーブルを作ること
 * SpringBootではEntityクラスを作ると自動的にテーブルを生成してくれるのでSQLをたたく必要はない
 */

package com.example.baseball.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * @EntityをつけることでDBのテーブルと紐づく
 */
@Data
public class PlayerForm {

	@NotEmpty
	private Integer id;

	@NotEmpty
	private String name;

	@NotNull
	@Min(value = 0)
	@Max(value = 150)
	private Integer age;

	@Size(max = 20)
	private String team;

	@SuppressWarnings("unused")
	private String position;

}