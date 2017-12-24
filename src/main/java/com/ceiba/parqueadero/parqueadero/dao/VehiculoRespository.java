package com.ceiba.parqueadero.parqueadero.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;

@Transactional
public interface VehiculoRespository extends CrudRepository<VehiculoEntity, String>{
}
