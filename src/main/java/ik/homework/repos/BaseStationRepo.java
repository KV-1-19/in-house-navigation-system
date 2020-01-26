package ik.homework.repos;

import ik.homework.domain.BaseStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseStationRepo extends CrudRepository<BaseStation, Long> {
    List<BaseStation> findByName(String name);
}
