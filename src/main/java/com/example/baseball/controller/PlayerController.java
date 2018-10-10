package com.example.baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.baseball.entity.Player;
import com.example.baseball.service.PlayerService;

@Controller
/*
 * クラスに対して@RequestMappingを付けておくと、クラス内のメソッド全てに適用される
 * つまりこのクラスのメソッドは全て、http://<ドメインなど>/playersから始まるURLにマッピングされている
 */
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@ModelAttribute
	PlayerForm playerForm() {
		return new PlayerForm();
	}

	@GetMapping
	String index(Model model) {

		List<Player> playerList = playerService.findAll();
		model.addAttribute("playerList", playerList);
		/*
		 * returnしている文字列を元に、src/main/resources/templates/配下からファイルを見つけてユーザに返している
		 */

		return "players/index";
	}

	@GetMapping("new")
	String newPlayer(Model model) {
		return "players/new";
	}

	@PostMapping
	/*
	 * メソッドの引数に@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
	 */
	String create(@Validated @ModelAttribute Player player, BindingResult bindingResult, Model model) {
		/*
		 * bindingReusltのhasErrorsメソッドでエラーの有無が確認できる。
		 * フィールド単位のエラーが欲しかったら、hasFieldErrorsを使う。
		 */
		if (bindingResult.hasErrors()) {
			model.addAttribute("judgeId", 0);
			return "players/new";
		}
		playerService.save(player);
		return "redirect:/players";
	}

	@DeleteMapping("delete/{id}")
	String destroy(@PathVariable Integer id) {
		playerService.delete(id);
		return "redirect:/players";
	}

	@GetMapping("/players{id}/edit")
	/*
	 * メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
	 */
	public String edit(@PathVariable Integer id, Model model) {
		Player player = playerService.findOne(id);
		model.addAttribute("player", player);
		return "players/edit";
	}

	@GetMapping("/players{id}")
	public String show(@PathVariable Integer id, Model model) {
		Player player = playerService.findOne(id);
		model.addAttribute("player", player);
		return "players/show";
	}

	@PutMapping("/players{id}")
	public String update(@PathVariable Integer id, @ModelAttribute Player player) {
		player.setId(id);
		playerService.save(player);
		return "redirect:/players";
	}
}