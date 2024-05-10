package isi.dan.app02.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isi.dan.app02.modelo.Equipo;
import isi.dan.app02.modelo.Jugador;
import isi.dan.app02.service.EquipoService;
import isi.dan.app02.service.JugadorService;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    
    @Autowired
    EquipoService equipoSvc;

    @Autowired
    JugadorService jugadorSvc;

    @GetMapping
    public ResponseEntity<List<Equipo>> buscarTodos(){
        return ResponseEntity.ok().body(equipoSvc.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable Integer id ){
        return ResponseEntity.ok().body(equipoSvc.buscarPorId(id));
    }

    @GetMapping("/jugador")
    public ResponseEntity<List<Jugador>> buscarTodosJug(
        @RequestParam(required = false, name="minPj") Integer min,
        @RequestParam(required = false, name="maxPj") Integer max
        ){
            if(Objects.nonNull(min) && Objects.nonNull(max) ){
                return ResponseEntity.ok().body(jugadorSvc.buscarPorRangoPartidos(min, max));
            }
        return ResponseEntity.ok().body(jugadorSvc.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Equipo> guardarEquipo(@RequestBody Equipo unEquipo){
        return ResponseEntity.ok().body(equipoSvc.guardar(unEquipo));
    }

    @PostMapping("/jugador")
    public ResponseEntity<Jugador> guardarJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok().body(jugadorSvc.guardar(jugador));
    }
}
