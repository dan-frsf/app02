package isi.dan.app02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.app02.dao.JugadorJpaRepo;
import isi.dan.app02.modelo.Jugador;

@Service
public class JugadorService {
    

    @Autowired JugadorJpaRepo repo;

    public Jugador guardar(Jugador j){
        return repo.save(j);
    }

    public List<Jugador> buscarTodos(){
        return repo.findAll();
    }

    public List<Jugador> buscarPorRangoPartidos(Integer min,Integer max){
        return repo.findAllByPjBetween(min, max);
    }
}
