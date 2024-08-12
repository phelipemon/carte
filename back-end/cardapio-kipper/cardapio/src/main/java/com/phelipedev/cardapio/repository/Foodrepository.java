package com.phelipedev.cardapio.repository;

import com.phelipedev.cardapio.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Foodrepository extends JpaRepository<Food, Long> {

}
