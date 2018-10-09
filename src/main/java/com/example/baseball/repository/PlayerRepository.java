package com.example.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baseball.entity.Player;

/*
 * findAllやsave等用意されている典型的な操作以外のことをしたくなったら、repositoryに追記していくことになる
 */

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}