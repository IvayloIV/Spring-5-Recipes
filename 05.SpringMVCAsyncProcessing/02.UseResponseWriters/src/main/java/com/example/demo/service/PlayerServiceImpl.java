package com.example.demo.service;

import com.example.demo.domain.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players = new ArrayList<>();

    public PlayerServiceImpl() {
        this.players.add(new Player("Pesho", 44));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
        this.players.add(new Player("Gosho", 12));
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(this.players);
    }
}
