package com.tnicacio.trabjpa.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tnica
 */
@Entity
@Table(name = "tb_participante")
public class Participante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Boolean status;
    
    @OneToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;
    
    @ManyToMany
    @JoinTable(name = "tb_participante_compromisso",
            joinColumns = {@JoinColumn(name = "participante_id")},
            inverseJoinColumns = {@JoinColumn(name = "compromisso_id")})
    private List<Compromisso> compromissos = new ArrayList<>();
    
    public Participante(){}

    public Participante(Long id, Boolean status, Contato contato) {
        this.id = id;
        this.status = status;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
