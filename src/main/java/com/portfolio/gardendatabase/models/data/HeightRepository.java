package com.portfolio.gardendatabase.models.data;


import com.portfolio.gardendatabase.models.Height;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeightRepository extends CrudRepository<Height, Integer> {
}
