package isi.dan.app02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.app02.dao.EquipoJpaRepo;
import isi.dan.app02.modelo.Equipo;

/**
 * EquipoService
 */
@Service
public class EquipoService {

    Logger log = LoggerFactory.getLogger(EquipoService.class);

    @Autowired
    EquipoJpaRepo repo;

    public Equipo guardar(Equipo unEquipo){
        return repo.save(unEquipo);
    }

    public List<Equipo> buscarTodos(){
        return repo.findAll();
    }

    public Equipo buscarPorId(Integer id){
        Equipo tmp = repo.findById(id).orElseThrow( () -> new RuntimeException("ERROR "));
        log.info("NOMBRE {}",tmp.getNombre());
        log.info("ID {}",tmp.getId());
        log.info("socios {}",tmp.getCantidadSocios());
        //log.info("JUGADORES {}",tmp.getJugadores());
        return tmp;
    }
}