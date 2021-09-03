package com.example.demo.web;

import com.example.demo.config.PlayerConfiguration;
import com.example.demo.domain.Pet;
import com.example.demo.domain.Player;
import com.example.demo.domain.Sport;
import com.example.demo.domain.validators.PlayerValidator;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/player")
@SessionAttributes("player")
public class PlayerController {

    Logger logger = LoggerFactory.getLogger(PlayerConfiguration.class);

    private PlayerService playerService;
    private PlayerValidator playerValidator;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerValidator playerValidator) {
        this.playerService = playerService;
        this.playerValidator = playerValidator;
    }

    @ModelAttribute("sports")
    public List<Sport> sports() {
        return playerService.getSports();
    }

    @GetMapping
    public String listPlayers(Model model) {
        List<Player> players = this.playerService.getAll();
        model.addAttribute("players", players);
        return "player";
    }

    @GetMapping(value = "/create")
    public String createPlayer(@RequestParam(value = "petName", required = false, defaultValue = "Out something!") String petName,
                               Model model) {
        Player player = new Player();
        player.setPet(new Pet(petName));
        model.addAttribute("player", player);
        return "submitPlayer";
    }

    @PostMapping(value = "/create")
    public String submitForm(@ModelAttribute("player") @Validated Player player,
                             BindingResult result, SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            logger.info(String.valueOf(sessionStatus.isComplete()));
            return "submitPlayer";
        } else {
            this.playerService.add(player);
            sessionStatus.setComplete();
            logger.info(String.valueOf(sessionStatus.isComplete()));
            return "redirect:successSubmitPlayer";
        }
    }

    @GetMapping(value = "/successSubmitPlayer")
    public String showSuccessPage() {
        return "successSubmitPlayer";
    }

    @InitBinder
    public void initBinding(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(this.playerValidator);
    }
}
