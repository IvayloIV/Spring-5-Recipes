package com.example.demo.service;

import com.example.demo.domain.Pet;
import com.example.demo.domain.Player;
import com.example.demo.domain.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players = new ArrayList<>();
    private List<Sport> sports = Arrays.asList(new Sport(1, "Futbol"), new Sport(2, "Basketball"));

    public PlayerServiceImpl() {
        this.players.add(new Player("Pesho", 44, new Pet("Dogo"), new Sport(1, "Futbol")));
        this.players.add(new Player("Gosho", 12, new Pet("Cato"), new Sport(2, "Basketball")));
    }

    @Override
    public List<Player> getAll() {
        return this.players.stream()
//                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> add(Player player) {
        this.players.add(player);
        return players;
    }

    @Override
    public List<Sport> getSports() {
        return sports;
    }

    @Override
    public Sport getSport(int id) {
        return sports.stream()
            .filter(a -> a.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
