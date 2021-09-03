package com.example.demo.web;

import com.example.demo.domain.Animal;
import com.example.demo.domain.AnimalType;
import com.example.demo.domain.Player;
import com.example.demo.domain.validation.ValidationStepOne;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/player")
@SessionAttributes("player")
public class PlayerController {

    private PlayerService playerService;
    private Map<Integer, String> pageForms = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostConstruct
    public void init() {
        pageForms.put(0, "playerForm");
        pageForms.put(1, "animalForm");
    }

    @GetMapping
    public String listPlayers(Model model) {
        List<Player> players = this.playerService.getAll();
        model.addAttribute("players", players);
        return "player";
    }

    @GetMapping(path = "create")
    public String showCreationForm(Model model) {
        Player player = new Player();
        player.setAnimal(new Animal());
        model.addAttribute("player", player);
        return "playerForm";
    }

    @PostMapping(path = "create", params = {"_cancel"})
    public String cancelForm(@RequestParam("_page") Integer page) {
        return pageForms.get(page);
    }

    @PostMapping(path = "create", params = {"_finish"})
    public String completeForm(@Valid @ModelAttribute Player player, BindingResult bindingResult,
                               SessionStatus sessionStatus, @RequestParam("_page") Integer page) {
        if (!bindingResult.hasErrors()) {
            playerService.create(player);
            sessionStatus.setComplete();
            return "redirect:/player";
        } else {
            return pageForms.get(page);
        }
    }

    @PostMapping(path = "create")
    public String submitForm(HttpServletRequest httpServletRequest,
                             @Validated(ValidationStepOne.class) @ModelAttribute Player player,
                             BindingResult bindingResult, @RequestParam("_page") Integer page) {
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        int index = 0;
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            if (parameter.startsWith("_target")) {
                index = Integer.parseInt(parameter.substring(parameter.length() - 1));
                break;
            }
        }

        if (index < page) {
            return pageForms.get(index);
        }

        if (!bindingResult.hasErrors()) {
            return pageForms.get(index);
        } else {
            return pageForms.get(page);
        }
    }

    @ModelAttribute("animalTypes")
    public Map<Integer, String> animalTypes() {
        return Arrays.stream(AnimalType.values())
                .collect(Collectors.toMap(Enum::ordinal, Enum::name));
    }
}
