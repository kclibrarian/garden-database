package data;

import model.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
