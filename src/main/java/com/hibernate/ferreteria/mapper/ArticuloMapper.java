package com.hibernate.ferreteria.mapper;

import com.hibernate.ferreteria.DTOs.ArticulosDTO;
import com.hibernate.ferreteria.entity.articulos;

public class ArticuloMapper {

    public static ArticulosDTO toDTO(articulos articulo){
        return new ArticulosDTO(
            articulo.getId(),
            articulo.getNombrearticulo(),
            articulo.getPrecio(),
            articulo.getExistencia()
        );
    }

    public static articulos toEntity(ArticulosDTO dto){
        articulos artic= new articulos();
        artic.setId((Long) dto.getId());
        artic.setNombrearticulo(dto.getNombrearticulo());
        artic.setPrecio(dto.getPrecio());
        artic.setExistencia(dto.getExistencia());
        return artic;
    }

}
