package com.hibernate.ferreteria.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.ferreteria.DTOs.ArticulosDTO;

import com.hibernate.ferreteria.Servicios.ArticulosService;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired 
    private ArticulosService servicio;
    
    @GetMapping
    public List<ArticulosDTO> listar(){
        return servicio.serv_consulta();

    }

    @GetMapping("/{id}")
    public ArticulosDTO buscaId(@PathVariable Long id){
        return servicio.ser_buscaId(id);

    }
    
    
    @PostMapping
    public ArticulosDTO insertaArticulo(@RequestBody ArticulosDTO dto){
        return servicio.serv_Inserta(dto);
    }
 
    @PutMapping("/{id}")
    public ArticulosDTO actualizArticulo (@PathVariable Long id, @RequestBody ArticulosDTO dto){
        return servicio.serv_Actualiza(id, dto);

    }

    @DeleteMapping("/{id}")
    public String borrArticulos(@PathVariable Long id){
        return servicio.eliminaArticulos(id);

    }

}
