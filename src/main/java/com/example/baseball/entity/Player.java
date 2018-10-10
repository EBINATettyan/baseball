/*
 * このソースの目的は、選手の情報を保存するplayerテーブルを作ること
 * SpringBootではEntityクラスを作ると自動的にテーブルを生成してくれるのでSQLをたたく必要はない
 */

package com.example.baseball.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @EntityをつけることでDBのテーブルと紐づく
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")

public class Player {
	/*
	 * @Idを付けた変数がテーブルのプライマーキーになる
	 */
	@Id
	/*
	 * @GeneratedValueをつけると連番が自動で振られるようになる
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Min(value = 0)
	@Max(value = 150)
	@Column(name = "age", nullable = false)
	private Integer age;

	@Size(max = 20)
	@Column(name = "team", nullable = true)
	private String team;

	@Column(name = "position", nullable = true)
	private String position;

	public void setId(Integer id2) {
		// TODO 自動生成されたメソッド・スタブ
	}
}