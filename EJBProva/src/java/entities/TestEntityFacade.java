
package entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alix
 */
@Stateless
public class TestEntityFacade extends AbstractFacade<Book> implements TestEntityFacadeLocal {
    @PersistenceContext(unitName = "EJBProvaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestEntityFacade() {
        super(Book.class);
    }

    @Override
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    public List<Book> getBooks() {
        return em.createQuery("From Book").getResultList();
    }
    
}
