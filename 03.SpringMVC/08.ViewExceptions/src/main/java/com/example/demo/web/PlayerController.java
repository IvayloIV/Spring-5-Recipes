package com.example.demo.web;

import com.example.demo.domain.Player;
import com.example.demo.exceptions.PlayerNotFoundException;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String listPlayers(Model model) throws PlayerNotFoundException {
        if (1 == 1) {
            throw new PlayerNotFoundException("Ops");
        }
        List<Player> players = this.playerService.getAll();
        model.addAttribute("players", players);
        return "player";
    }

    @PostMapping
    public String submitForm(@RequestParam("playerName") String playerName, Model model) {
        List<Player> players = this.playerService.add(playerName);
        model.addAttribute("players", players);
        return "player";
    }
}
