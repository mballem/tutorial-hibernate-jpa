package br.mb.tutorialHibernateJpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CONTATOS")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "APELIDO")
    private String apelido;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO")
    private Date dtNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", dtNascimento=" + dtNascimento +
                '}';
    }
}
