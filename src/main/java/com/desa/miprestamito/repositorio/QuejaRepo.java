package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuejaRepo extends CrudRepository<Queja, Long> {

    public Iterable<Queja> findByIdUsuario(Long id);


    public List<Queja> findByIdTipoQueja(Long id);

    /*
        public Iterable<Queja> findByPuntoAtencionId(Long id);
     */
    public List<Queja> findByIdEstado(Long id);


}
