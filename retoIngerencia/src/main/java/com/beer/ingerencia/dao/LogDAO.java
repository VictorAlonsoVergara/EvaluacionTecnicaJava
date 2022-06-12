package com.beer.ingerencia.dao;

import com.beer.ingerencia.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDAO extends JpaRepository<Log, Integer> {
}
