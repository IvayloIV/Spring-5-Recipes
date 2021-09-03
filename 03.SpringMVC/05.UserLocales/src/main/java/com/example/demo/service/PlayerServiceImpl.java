package com.example.demo.service;

import com.example.demo.domain.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players = new ArrayList<>();

    public PlayerServiceImpl() {
        this.players.add(new Player("Pesho", 44));
        this.players.add(new Player("Gosho", 12));
    }

    @Override
    public List<Player> getAll() {
        return this.players.stream()
//                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> add(String playerName) {
        Player player = new Player(playerName, 14);
        this.players.add(player);
        return players;
    }
}
