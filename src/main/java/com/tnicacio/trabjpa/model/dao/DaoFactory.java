package com.tnicacio.trabjpa.model.dao;

import com.tnicacio.trabjpa.em.EM;
import com.tnicacio.trabjpa.model.dao.impl.ContatoDaoEM;
import com.tnicacio.trabjpa.model.dao.impl.LocalDaoEM;
import com.tnicacio.trabjpa.model.dao.impl.ParticipanteDaoEM;

/**
 *
 * @author tnica
 */
public class DaoFactory {
    
    public static ContatoDAO createContatoDao(){
        return new ContatoDaoEM(EM.getEntityManager());
    }

    public static ParticipanteDAO createParticipanteDao(){
        return new ParticipanteDaoEM(EM.getEntityManager());
    }

    public static LocalDAO createLocalDao(){
        return new LocalDaoEM(EM.getEntityManager());
    }
}
