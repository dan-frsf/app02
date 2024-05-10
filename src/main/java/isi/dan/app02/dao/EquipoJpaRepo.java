package isi.dan.app02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.dan.app02.modelo.Equipo;

@Repository
public interface EquipoJpaRepo extends JpaRepository<Equipo,Integer> {
    
}
