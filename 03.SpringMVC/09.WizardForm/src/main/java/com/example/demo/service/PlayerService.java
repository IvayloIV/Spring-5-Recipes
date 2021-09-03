package com.example.demo.service;

import com.example.demo.domain.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> getAll();

    public void create(Player player);
}
