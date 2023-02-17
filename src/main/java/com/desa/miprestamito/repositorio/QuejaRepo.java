package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuejaRepo extends CrudRepository<Queja, Long> {


}
