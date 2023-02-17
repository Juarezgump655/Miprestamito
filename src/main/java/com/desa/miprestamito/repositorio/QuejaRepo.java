package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuejaRepo extends JpaRepository<Queja, Long> {

    public Iterable<Queja> findByUsuarioId(Long id);

    public Iterable<Queja> findByPuntoAtencionId(Long id);

    public Iterable<Queja> findByEstado(Long id);
}
