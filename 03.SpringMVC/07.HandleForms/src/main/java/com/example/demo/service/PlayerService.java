package com.example.demo.service;

import com.example.demo.domain.Player;
import com.example.demo.domain.Sport;

import java.util.List;

public interface PlayerService {

    public List<Player> getAll();

    public List<Player> add(Player player);

    public List<Sport> getSports();

    public Sport getSport(int id);
}
