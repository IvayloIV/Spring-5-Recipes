package com.example.demo.service;

import com.example.demo.domain.Animal;
import com.example.demo.domain.AnimalType;
import com.example.demo.domain.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players = new ArrayList<>();

    public PlayerServiceImpl() {
        this.players.add(new Player("Pesho", 44, new Animal("Josh", AnimalType.DOG)));
        this.players.add(new Player("Gosho", 12, new Animal("Tomson", AnimalType.LION)));
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(this.players);
    }

    @Override
    public void create(Player player) {
        players.add(player);
    }
}
