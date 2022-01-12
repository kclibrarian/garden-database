package com.portfolio.gardendatabase.models.data;

import com.portfolio.gardendatabase.models.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, Integer> {
}
