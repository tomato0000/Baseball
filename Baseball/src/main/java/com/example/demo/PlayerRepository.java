package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Playerdomain;

@Repository
public interface PlayerRepository extends JpaRepository<Playerdomain, Long> {


}