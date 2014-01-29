package com.cencolshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cencolshare.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
