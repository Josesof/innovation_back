package com.co.nexos.innovacion.sensor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.innovacion.entity.Sensor;

@Repository
public interface ISensorRepository extends CrudRepository<Sensor, Integer> {

}
