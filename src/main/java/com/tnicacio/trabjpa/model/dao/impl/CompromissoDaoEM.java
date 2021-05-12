package com.tnicacio.trabjpa.model.dao.impl;

import com.tnicacio.trabjpa.em.EM;
import com.tnicacio.trabjpa.model.dao.CompromissoDAO;
import com.tnicacio.trabjpa.model.entities.Compromisso;
import com.tnicacio.trabjpa.model.entities.Contato;
import com.tnicacio.trabjpa.model.entities.Local;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tnica
 */
public class CompromissoDaoEM implements CompromissoDAO{

    private EntityManager em;
    
    public CompromissoDaoEM(EntityManager em){
        this.em = em;
    }
    
    @Override
    public List<Compromisso> findByLocal(Local local) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compromisso findByContato(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Compromisso obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Inserindo Compromisso " + obj.getId());
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Compromisso inserido com sucesso!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na inserção do Compromisso. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void update(Compromisso obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Atualizando Compromisso " + obj.getId());
            em.merge(obj);
            em.getTransaction().commit();
            System.out.println("Compromisso atualizado com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na atualização do Compromisso. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        Compromisso compromisso = findById(id);
        if (compromisso == null){
            System.out.println("Compromisso não encontrado");
            return;
        }

        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            
            if (!em.isOpen()) {
                em = EM.getEntityManager();
                em.getTransaction().begin();
            }
            
            if (!em.contains(compromisso)) {
                compromisso = em.merge(compromisso);
            }
            
            System.out.println("Excluindo Compromisso de id " + id);
            em.remove(compromisso);
            em.getTransaction().commit();
            System.out.println("Compromisso excluído com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na exclusão do Compromisso. Realizado rollback...");
            }
        } finally {
            EM.close();
        }   
    }

    @Override
    public Compromisso findById(Long id) {
        Compromisso compromisso = null;
        try {
            em = EM.getEntityManager();
            compromisso = em.find(Compromisso.class, id);
            System.out.println("Busca pelo Compromisso " + id + " finalizada");

        } catch(Exception e) {
            System.out.println("Erro na busca pelo Compromisso " + id);
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return compromisso;   
    }

    @Override
    public List<Compromisso> findAll() {
        List<Compromisso> compromissos = new ArrayList<>();
        try {
            em = EM.getEntityManager();         
            compromissos = em.createQuery(
                "SELECT c FROM Compromisso c "
                + "ORDER BY c.data desc, c.hora desc", Compromisso.class)
                .getResultList();
            
            System.out.println("Busca pelos Compromissos finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca pelos Compromissos");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return compromissos;    
    }
    
}
