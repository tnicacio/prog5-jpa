package com.tnicacio.trabjpa.application;

import com.tnicacio.trabjpa.model.dao.ContatoDAO;
import com.tnicacio.trabjpa.model.dao.DaoFactory;
import com.tnicacio.trabjpa.model.entities.Contato;
import java.util.stream.Collectors;

/**
 *
 * @author tnica
 */
public class Program {
    
    public static void main(String... args) {
        ContatoDAO contatoDao = DaoFactory.createContatoDao();
        
        Contato contato1 = new Contato(null, "Tiago", "1234-1234", "email@mail.com");
        contatoDao.insert(contato1);

//        Contato contato = contatoDao.findById(2L);
//        if (contato != null) {
//            System.out.println("contato1: " + contato.getNome());
//        }
//        Contato contato2 = contatoDao.findById(1L);
//        if (contato2 != null) {
//            System.out.println("contato2: " + contato2.getNome());
//        }

//        System.out.println(contatoDao.findAll().stream().map(x -> x.getNome()).collect(Collectors.toList()));
//        System.out.println(contatoDao.findByNome("ag").stream().map(x -> x.getNome()).collect(Collectors.toList()));
        
//        contatoDao.deleteById(1L);
        System.out.println(contatoDao.findAll().stream().map(x -> x.getNome()).collect(Collectors.toList()));
    }
}
