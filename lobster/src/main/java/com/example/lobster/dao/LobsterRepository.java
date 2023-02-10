package com.example.lobster.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lobster.model.Lobster;

@Repository
public interface LobsterRepository extends CrudRepository<Lobster, Integer> {

}
