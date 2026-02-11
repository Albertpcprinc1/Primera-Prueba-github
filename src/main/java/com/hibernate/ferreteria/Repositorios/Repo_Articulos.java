package com.hibernate.ferreteria.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hibernate.ferreteria.entity.articulos;

public interface Repo_Articulos extends JpaRepository<articulos, Long>{
    

}
