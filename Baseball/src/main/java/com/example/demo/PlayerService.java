package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Playerdomain;
import com.example.demo.PlayerRepository;

@Service
public class PlayerService {
    // ①
    @Autowired
    private PlayerRepository playerRepository;

    public List<Playerdomain> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Playerdomain> findOne(Long id) {
        return playerRepository.findById(id);
    }

    public Playerdomain save(Playerdomain player) {
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}