package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Playerdomain;
import com.example.demo.PlayerService;

@Controller
@RequestMapping("/players") // ①
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) { // ②
        List<Playerdomain> players = playerService.findAll();
        model.addAttribute("players", players); // ③
        return "players/index"; // ④
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Optional<Playerdomain> player = playerService.findOne(id);
        model.addAttribute("players", player);
        return "players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Playerdomain> player = playerService.findOne(id);
        model.addAttribute("players", player);
        return "players/show";
    }

    @PostMapping
    public String create(@ModelAttribute Playerdomain player) { // ⑥
        playerService.save(player);
        return "redirect:/players"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Playerdomain player) {
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }
}