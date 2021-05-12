package com.tnicacio.trabjpa.model.dao;

import com.tnicacio.trabjpa.em.EM;
import com.tnicacio.trabjpa.model.dao.impl.ContatoDaoEM;

/**
 *
 * @author tnica
 */
public class DaoFactory {
    
    public static ContatoDAO createContatoDao(){
        return new ContatoDaoEM(EM.getEntityManager());
    }
}
