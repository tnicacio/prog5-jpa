package com.tnicacio.trabjpa.model.dao;

import com.tnicacio.trabjpa.model.entities.Compromisso;
import com.tnicacio.trabjpa.model.entities.Contato;
import com.tnicacio.trabjpa.model.entities.Local;
import java.util.List;

/**
 *
 * @author tnica
 */
public interface CompromissoDAO extends DaoGeneric<Compromisso>{
 
    List<Compromisso> findByLocal(Local local);
    Compromisso findByContato(Contato contato);
}
