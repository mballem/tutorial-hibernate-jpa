package br.mb.tutorialHibernateJpa.agenda;

import br.mb.tutorialHibernateJpa.dao.ContatoDao;
import br.mb.tutorialHibernateJpa.model.Contato;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 22/02/2011
 * Time: 17:12:59
 * http://mballem.wordpress.com
 */
public class MainTest {
    public static void main(String[] args) {

        //create();
        //inserir();
        //listar();
        buscaById();

    }

    private static void buscaById() {
        Contato c = new ContatoDao().findById(5L);
        System.out.println(c.toString());
    }

    private static void create() {
        Ejb3Configuration cfg = new Ejb3Configuration();

        // OBS: agenda eh o nome de meu persistence-unit no persistence.xml.
        // O configure vai procurar o persistence.xml dentro da pasta META-INF que tem que estar no classpath
        cfg.configure("agenda", null);
        /*cfg.addAnnotatedClass(Contato.class);*/
        Configuration hbmcfg = cfg.getHibernateConfiguration();

        SchemaExport schemaExport = new SchemaExport(hbmcfg);
        schemaExport.create(true, true);
    }

    private static void listar() {
        List<Contato> contatos = null;
        try {
            contatos = new ContatoDao().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Contato contato : contatos) {
            System.out.println(contato.toString());
        }
    }

    private void salvar(Contato c) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");    
        EntityManager em = emf.createEntityManager();

         try {
            em.getTransaction().begin();
            //em.refresh(registro);
            em.persist(c);
            //em.flush();
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro INSERIDO no banco de dados !");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void inserir() {
        MainTest mt = new MainTest();

        Contato c = new Contato();
        c.setNome("Marcus");
        c.setApelido("mano");
        c.setDtNascimento(formatarData("10/10/1979"));

        mt.salvar(c);
        //dao.save(c);

        Contato cc = new Contato();
        cc.setNome("Malas");
        cc.setApelido("mano");
        cc.setDtNascimento(formatarData("10/10/1979"));

        mt.salvar(cc);
    }        



    private static Date formatarData(String data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new Date(formatter.parse(data).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
