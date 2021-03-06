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
public class CompromissoDaoEM implements CompromissoDAO {

    private EntityManager em;

    public CompromissoDaoEM(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Compromisso> findByLocal(Local local) {
        List<Compromisso> compromissos = new ArrayList<>();
        if (local == null || local.getId() == null) {
            return compromissos;
        }

        try {
            em = EM.getEntityManager();

            compromissos = em.createQuery(
                    "SELECT c FROM Compromisso c "
                    + "JOIN c.local loc "
                    + "WHERE loc = :local", Compromisso.class)
                    .setParameter("local", local)
                    .getResultList();

            System.out.println("Busca pelos Compromissos com Local " + local.getId() + " finalizada");
        } catch (Exception e) {
            System.out.println("Erro na busca pelos Compromissos com Local " + local.getId());
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return compromissos;
    }

    @Override
    public List<Compromisso> findByContato(Contato contato) {

        List<Compromisso> compromissos = new ArrayList<>();
        if (contato == null || contato.getId() == null) {
            return compromissos;
        }

        try {
            em = EM.getEntityManager();

            compromissos = em.createQuery(
                    "SELECT c FROM Compromisso c "
                    + "JOIN c.participantes part "
                    + "JOIN part.contato cont "
                    + "WHERE cont = :contato", Compromisso.class)
                    .setParameter("contato", contato)
                    .getResultList();

            System.out.println("Busca pelos Compromissos do Contato " + contato.getNome() + " finalizada");
        } catch (Exception e) {
            System.out.println("Erro na busca pelos Compromissos do Contato " + contato.getNome());
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return compromissos;
    }

    @Override
    public void insert(Compromisso obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Inserindo novo compromisso");
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Compromisso inserido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na inser????o do Compromisso. Realizado rollback...");
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
            System.out.println("Compromisso " + obj.getId() + " atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na atualiza????o do Compromisso " 
                        + obj.getId() + ". Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        Compromisso compromisso = findById(id);
        if (compromisso == null) {
            System.out.println("Compromisso n??o encontrado");
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
            System.out.println("Compromisso exclu??do com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (EM.isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na exclus??o do Compromisso. Realizado rollback...");
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

        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println("Erro na busca pelos Compromissos");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return compromissos;
    }

}
