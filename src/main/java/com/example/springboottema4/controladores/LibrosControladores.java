package com.example.springboottema4.controladores;

import com.example.springboottema4.entity.Libros;
import com.example.springboottema4.servis.LibrosServis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibrosControladores {
    //atributo
    private LibrosServis librosServis;

    private final Logger log = LoggerFactory.getLogger(LibrosControladores.class);

    //constructor
    public LibrosControladores(LibrosServis librosServis) {
        this.librosServis = librosServis;
    }

    //buscar libros
    @GetMapping("/api/libros")
    public List<Libros> BuscarListaDeLibros(){
        System.out.println("hola desde /api/libros");
        return librosServis.BuscarListaDeLibros();
    }

    //buscar un solo libro
   // @GetMapping("api/libros/{id}")
  //  public ResponseEntity<Libros> findOneById(@PathVariable Long id){
    //    Optional<Libros> librosopb = librosServis.BuscarListaDeLibros(id);
      //  System.out.println("hola desde api/libros/{id}");


        //opcion 1
        //if (librosopb.isPresent()){
          //  return ResponseEntity.ok(librosopb.get());
        //}else{
          //  return ResponseEntity.notFound().build();//build significa que construlla una respuesta de tipo notfound
        //}

        //opcion 2
        //return librosopb.isPresent() ? librosopb.get() : null;
        //return librosopb.isPresent() ? ResponseEntity.ok(librosopb.get()) : ResponseEntity.notFound().build();
    //}

    //crear libro
    @PostMapping("api/libros")
    public Libros create(@RequestBody Libros libros){
        //guardar el libro recibido por parametros
        return librosServis.guardarLibros(libros);
    }

    //actualizar libro
    @PutMapping("api/libros")
    public ResponseEntity<Libros>  update(@RequestBody Libros libros){

        //guardar los datos recibido por parametros
        if (libros.getId() == null){//quiere decir que el libro ya esta creado
            log.warn("no puedes actualizar un libro que no existe");
            return ResponseEntity.badRequest().build();
        }
        if(!librosServis.existsById(libros.getId())){
            log.warn("no puedes actualizar un usuario que no existe");
            return ResponseEntity.notFound().build();
        }
        Libros resultado = librosServis.guardarLibros(libros);
        return ResponseEntity.ok(resultado);
    }

    //borrar libro
    @DeleteMapping("/api/delate/{id}")
    public ResponseEntity<Libros> delate(@RequestBody Long id){

        if(!librosServis.existsById(id)){
            log.warn("no puedes eliminar un usuario que no existe");
            return ResponseEntity.notFound().build();
        }
        librosServis.deletelibrosByid(id);
        return ResponseEntity.noContent().build();
    }





    //Ejemplo(teoria escrita en papel)
   /* @GetMapping("/hola")
    public String holamundo(){
        return "HOLA MUNDO!!! que tal vamos! genial me voy";
    }*/


}
