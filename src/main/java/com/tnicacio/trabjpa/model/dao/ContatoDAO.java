package com.tnicacio.trabjpa.model.dao;

import com.tnicacio.trabjpa.model.entities.Contato;
import java.util.List;

/**
 *
 * @author tnica
 */
public interface ContatoDAO extends DaoGeneric<Contato>{
    
    List<Contato> findByNome(String nome);
}
