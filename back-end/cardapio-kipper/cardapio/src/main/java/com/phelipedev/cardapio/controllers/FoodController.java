package com.phelipedev.cardapio.controllers;

import com.phelipedev.cardapio.domain.Food;
import com.phelipedev.cardapio.domain.FoodRequestDTO;
import com.phelipedev.cardapio.domain.FoodResponseDTO;
import com.phelipedev.cardapio.repository.Foodrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private Foodrepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream()
                .map(FoodResponseDTO::new)
                .collect(Collectors.toList());

        return foodList;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

}
