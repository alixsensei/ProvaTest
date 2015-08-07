
import it.sensei.assunzioni.Assunzione;
import it.sensei.assunzioni.Azienda;
import it.sensei.assunzioni.Dipendente;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class Prova {
    
    private static SessionFactory factory;
    static List<Object[]> result;
    
    public static void main(String[] args) {
        
        try{
            factory = (SessionFactory) new AnnotationConfiguration().configure().buildSessionFactory();  
        } catch(Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        Prova prova = new Prova();
        String date = 1977 + "-" + 9 + "-" + 10;
        java.util.Date utilDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            utilDate = formatter.parse(date);
        } catch (ParseException e) {
            System.out.println(e.toString());
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        /*
        Integer dip1 = prova.addDipendente("Marco", "Cavagnari", sqlDate, "ZAQEXFGH");
        System.out.println("Il dato è inserito nella posizione: " + dip1);
        
        Integer azienda = prova.addAzienda("Saipem", "Bancario", "Bd Dolez",69,12000,"Brazzaville","Congo","0125555828","Dimitri Berbatov");
        System.out.println("Il dato è inserito nella posizione: " + azienda);
        
        Integer ass = prova.addAssunzione("Euroclear", 6, sqlDate);
        System.out.println("Il dato è inserito nella posizione: " + ass);
        */
        System.out.println("Ecco la lista dei dipendenti:");
        prova.listDipendenti();
        System.out.println();
        System.out.println("Ecco la lista delle aziende");
        prova.listAziende();
        System.out.println();
        System.out.println("Ecco la lista delle assunzioni");
        prova.listAssunzioni();
    }
    
    // Metodo che aggiunge un dipendente nella tabella
    public Integer addDipendente(String nome, String cognome, Date data, String cod_fisc) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer idDip = null;
        try {
            tx = session.beginTransaction();
            Dipendente dip = new Dipendente();
            dip.setNome(nome);
            dip.setCognome(cognome);
            dip.setDataDiNascita(data);
            dip.setCodiceFiscale(cod_fisc);
            System.out.println("end set Dipendente");
            idDip = (Integer) session.save(dip);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        }
        finally {
            session.close();
        }
        return idDip;
    }
    
    // Metodo che aggiunge un dipendente nella tabella
    public Integer addAzienda(String nome, String settore, String via, int num, int cap, String citta, String paese, String tel, String resp) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer idAz = null;
        try {
            tx = session.beginTransaction();
            Azienda az = new Azienda();
            az.setNome(nome);
            az.setSettore(settore);
            az.setVia(via);
            az.setNumeroCivico(num);
            az.setCap(cap);
            az.setCitta(citta);
            az.setPaese(paese);
            az.setTelefono(tel);
            az.setResponsabile(resp);
            idAz = (Integer) session.save(az);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        }
        finally {
            session.close();
        }
        return idAz;
    }
    
    // Metodo che aggiunge un dipendente nella tabella
    public Integer addAssunzione(String nome, int dip,Date data) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer idAss = null;
        try {
            tx = session.beginTransaction();
            Assunzione ass = new Assunzione();
            ass.setNomeAzienda(nome);
            ass.setDipendente(dip);
            ass.setDataAssunzione(data);
            idAss = (Integer) session.save(ass);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        }
        finally {
            session.close();
        }
        return idAss;
    }
    
    public void listDipendenti() {
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List dipendenti = session.createQuery("FROM dipendente").list();
            
            //List dipendenti = session.createSQLQuery("SELECT * FROM dipendente").list();
            //for (Iterator iterator = dipendenti.iterator(); iterator.hasNext();) {
             //   Iterator<Object[]> iteratore = dipendenti.iterator();
           //for (Iterator<Dipendente> iterator = dipendenti.iterator(); iterator.hasNext();) {
                Iterator iterator = dipendenti.iterator();
                  while(iterator.hasNext()) {
                Dipendente dipendente = (Dipendente)iterator.next();
         
                System.out.print("Id: " + dipendente.getId());
                System.out.print(", Nome: " + dipendente.getNome());
                System.out.print(", Cognome: " + dipendente.getCognome());
                System.out.print(", Data di nascita: " + dipendente.getDataDiNascita());
                System.out.println(", Codice fiscale: " + dipendente.getCodiceFiscale());
                System.out.println();
            }
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void listAziende() {
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List aziende = session.createQuery("FROM azienda").list();
            //List aziende = session.createSQLQuery("SELECT * FROM azienda").list();
            for (Iterator iterator = aziende.iterator(); iterator.hasNext();) {
                Azienda azienda = (Azienda)iterator.next();
                System.out.print("Codice azienda: " + azienda.getCodice());
                System.out.print(", Nome azienda: " + azienda.getNome());
                System.out.print(", Settore: " + azienda.getSettore());
                System.out.print(", Via: " + azienda.getVia());
                System.out.print(", n°: " + azienda.getNumeroCivico());
                System.out.print(", CAP: " + azienda.getCap());
                System.out.print(", Città: " + azienda.getCitta());
                System.out.print(", Paese: " + azienda.getPaese());
                System.out.print(", Tel: " + azienda.getTelefono());
                System.out.println(", Responsabile: " + azienda.getResponsabile());
                System.out.println();
            }
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void listAssunzioni() {
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List assunzioni = session.createQuery("FROM assunzioni").list();
            //List assunzioni = session.createSQLQuery("SELECT * FROM assunzione").list();
            for (Iterator iterator = assunzioni.iterator(); iterator.hasNext();) {
                Assunzione assunzione = (Assunzione) iterator.next();
                System.out.print("Codice: " + assunzione.getCodice());
                System.out.print(", Nome azienda: " + assunzione.getNomeAzienda());
                System.out.print(", Codice dipendente: " + assunzione.getDipendente());
                System.out.println(", Data di assunzione: " + assunzione.getDataAssunzione());
                System.out.println();
            }
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
}
