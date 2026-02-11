package com.hibernate.ferreteria.Servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.ferreteria.DTOs.ArticulosDTO;
import com.hibernate.ferreteria.Repositorios.Repo_Articulos;
import com.hibernate.ferreteria.entity.articulos;
import com.hibernate.ferreteria.mapper.ArticuloMapper;

@Service
public class ArticulosService {
    @Autowired
    private Repo_Articulos repo;
    
    public List<ArticulosDTO> serv_consulta(){
        return repo.findAll().stream().map(ArticuloMapper::toDTO)
                .collect(Collectors.toList());
        
    }

    public ArticulosDTO ser_buscaId(Long id){
        articulos articuloporId = repo.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Articulo con id: "+id+ "no encontrado"));
        return ArticuloMapper.toDTO(articuloporId);

    }

    public ArticulosDTO serv_Inserta(ArticulosDTO dto){
        articulos articulo = ArticuloMapper.toEntity(dto);
        articulos insertado = repo.save(articulo);
        return ArticuloMapper.toDTO(insertado);

    }

    public ArticulosDTO serv_Actualiza (Long id, ArticulosDTO dto){
        Optional<articulos> existe = repo.findById(id);
        if (existe.isPresent()){
            articulos articulo = existe.get();
            articulo.setNombrearticulo(dto.getNombrearticulo());
            articulo.setPrecio(dto.getPrecio());
            articulo.setExistencia(dto.getExistencia());

            articulos actualizado = repo.save(articulo);

            return ArticuloMapper.toDTO(actualizado);
        }else {
            throw new RuntimeException("Articulo no encontrado con id: "+id);
        }        
        
    }

    public String eliminaArticulos (Long id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            //return "Articulo eliminado correctamente";
            //res.put("msg", "Articulo editado");
            //return res;
            //return "{ msg: Articulo editado }";
            return null;
        }else {
            return "Articulo: "+id + " No econtrado";
        }
    }



}
