package br.mb.tutorialHibernateJpa.dao;

import br.mb.tutorialHibernateJpa.model.Contato;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 22/02/2011
 * Time: 16:45:54
 * http://mballem.wordpress.com
 */
public class ContatoDao extends GenericDao<Contato> {

    public void salvar(Contato contato) {
        save(contato);
    }

    public void alterar(Contato contato) {
        update(contato);
    }

    public void excluir(long id) {
        Contato c = findById(id);
        delete(c);
    }
}
