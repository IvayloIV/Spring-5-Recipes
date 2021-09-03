package com.example.demo.web;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String listPlayers(Model model) {
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
