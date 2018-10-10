package com.example.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baseball.entity.Player;
import com.example.baseball.repository.PlayerRepository;

@Service
public class PlayerService {

	/*
	 * @Autowiredを付けて宣言するとnewしなくてもインスタンス化して使うことができる
	 */

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> findAll() {
		List<Player> playerList = playerRepository.findAll();
		return playerList;
	}

	public Player findOne(Integer id) {
		// メソッド名がfindOneからfindByIdに変わった
		// Optionalを返すようになったので取得できなかった場合の処理`.orElse(null)`を追加
		return playerRepository.findById(id).orElse(null);
	}

	public Player save(Player player) {
		return playerRepository.save(player);
	}

	public void delete(Integer id) {
		// メソッド名がdeleteからdeleteByIdに変わった
		playerRepository.deleteById(id);
	}

	public Player update(Player player) {
		return playerRepository.save(player);
	}
}