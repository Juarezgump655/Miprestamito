package com.desa.miprestamito.servicio;

import com.desa.miprestamito.modelo.Queja;

public interface QuejaService {

    public Queja save(Queja queja);

    public Iterable<Queja> listarQuejas();

    public Queja listarId(Long id);

    public Iterable<Queja> listarQuejasPorUsuario(Long id);

    public Iterable<Queja> listarQuejasPorPuntoAtencion(Long id);

    public Iterable<Queja> listarQuejasPorEstado(Long estado);


}
