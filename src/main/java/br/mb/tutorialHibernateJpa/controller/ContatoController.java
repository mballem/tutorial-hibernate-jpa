package br.mb.tutorialHibernateJpa.controller;

import br.mb.tutorialHibernateJpa.dao.ContatoDao;
import br.mb.tutorialHibernateJpa.model.Contato;

import javax.swing.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 18/02/2011
 * Time: 15:40:58
 * http://mballem.wordpress.com
 */
public class ContatoController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String nome, String apelido, String dtNascimento) throws Exception {
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(formatarData(dtNascimento));

        new ContatoDao().salvar(contato);
    }

    public void alterar(long id, String nome, String apelido, String dtNascimento) throws Exception {
        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(formatarData(dtNascimento));

        new ContatoDao().alterar(contato);
    }

    public List listaContatos() {
        ContatoDao dao = new ContatoDao();
        try {
            return dao.findAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar contato\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(long id) throws Exception {
        new ContatoDao().excluir(id);
    }

    public Contato buscaContatoPorNome(String nome) throws Exception {
        ContatoDao dao = new ContatoDao();
        return (Contato) dao.findByName(nome);
    }
}
