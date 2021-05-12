package com.tnicacio.trabjpa.application;

import com.tnicacio.trabjpa.model.dao.CompromissoDAO;
import com.tnicacio.trabjpa.model.dao.ContatoDAO;
import com.tnicacio.trabjpa.model.dao.DaoFactory;
import com.tnicacio.trabjpa.model.dao.LocalDAO;
import com.tnicacio.trabjpa.model.dao.ParticipanteDAO;
import com.tnicacio.trabjpa.model.entities.Compromisso;
import com.tnicacio.trabjpa.model.entities.Contato;
import com.tnicacio.trabjpa.model.entities.Local;
import com.tnicacio.trabjpa.model.entities.Participante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tnica
 */
public class Program {
    
    public static void main(String... args) {
        ContatoDAO contatoDao = DaoFactory.createContatoDao();
        LocalDAO localDao = DaoFactory.createLocalDao();
        ParticipanteDAO participanteDao = DaoFactory.createParticipanteDao();
        CompromissoDAO compromissoDao = DaoFactory.createCompromissoDao();

//        Contato contato1 = new Contato(null, "Tiago", "1234-1234", "tiago@mail.com");
//        Contato contato2 = new Contato(null, "João", "3333-3333", "jao@mail.com");
//        Contato contato3 = new Contato(null, "Maria", "9876-5432", "maria@mail.com");
//        Contato contato4 = new Contato(null, "Zezinho", "1111-2222", "ze@mail.com");
//        List<Contato> contatos = Arrays.asList(contato1, contato2, contato3, contato4);
//        contatos.stream().forEach(contato -> contatoDao.insert(contato));
//        
//        Local local1 = new Local(null, "Apartamento", "Rua João Pessoa", "Centro", "Blumenau", "631", "89012-471");
//        Local local2 = new Local(null, "Casa", "Rua dos Alfaiates", "Velha", "São Paulo", "312", "55555-432");
//        Local local3 = new Local(null, "Sítio", "Rodovia", "BR-101", "Tapapino", "Fictício", "12345-678");
//        List<Local> locais = Arrays.asList(local1, local2, local3);
//        locais.stream().forEach(local -> localDao.insert(local));
//        
//        try {
//            Participante participante1 = new Participante(null, Boolean.TRUE, contatoDao.findByNome("tiago").get(0));
//            Participante participante2 = new Participante(null, Boolean.TRUE, contatoDao.findByNome("maria").get(0));
//            List<Participante> participantes = Arrays.asList(participante1, participante2);
//            participantes.stream().forEach(participante -> participanteDao.insert(participante));
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        Local localDoCompromisso1 = localDao.findById(1L);
//        Compromisso compromisso1 = new Compromisso(null, 
//                                        Date.valueOf(LocalDate.of(2021,Month.FEBRUARY, 12)), 
//                                        Time.valueOf(LocalTime.of(14, 30)),
//                                        Time.valueOf(LocalTime.of(0, 30)),
//                                        localDoCompromisso1);
//        compromissoDao.insert(compromisso1);
        
//        System.out.println(compromissoDao.findByLocal(localDoCompromisso1 )
//                .stream().map(x -> x.getId()).collect(Collectors.toList()));
        List<Contato> contatos1 = contatoDao.findByNome("tiago");
        if (contatos1.size() > 0 && contatos1.get(0) != null) {
            System.out.println(compromissoDao.findByContato(contatos1.get(0))
                    .stream().map(comp -> comp.getHora()).collect(Collectors.toList()));
        }
        
//        System.out.println(
//        compromissoDao.findByLocal(localDoCompromisso1).get(0).getParticipantes().get(0).getContato().getNome()
//        );
//  
//        Compromisso comp2 = compromissoDao.findById(2L);
//        Participante participante1 = participanteDao.findById(1L);
//        participante1.getCompromissos().add(comp2);
//        participanteDao.update(participante1);

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

    }
}
