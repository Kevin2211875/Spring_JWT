package com.prueba.JWT.Repository;


import com.prueba.JWT.Model.Tipodocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipodocumentoRepository extends JpaRepository<Tipodocumento, Integer> {
}
