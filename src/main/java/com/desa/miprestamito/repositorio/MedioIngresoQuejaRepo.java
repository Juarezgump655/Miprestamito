package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.MedioIngeresoQueja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioIngresoQuejaRepo extends CrudRepository<MedioIngeresoQueja, Long> {


}
