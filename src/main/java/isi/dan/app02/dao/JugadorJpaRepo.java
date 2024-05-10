package isi.dan.app02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.dan.app02.modelo.Jugador;

@Repository
public interface JugadorJpaRepo extends JpaRepository<Jugador,Integer> {
 
   List<Jugador> findAllByPjBetween(Integer v1, Integer v2);
}
