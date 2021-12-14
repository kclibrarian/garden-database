package com.portfolio.gardendatabase.data;

import com.portfolio.gardendatabase.models.Month;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends CrudRepository<Month, Integer> {
}
