/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class HistoryFacade extends AbstractFacade<History> {

    @PersistenceContext(unitName = "SPTVR19WebLibraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryFacade() {
        super(History.class);
    }

    public List<History> findHistoriesWithReadBook(Reader reader) {
        try {
            return em.createQuery("SELECT h FROM History h WHERE h.returnDate = NULL AND h.reader = :reader")
                    .setParameter("reader", reader)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Book> findReadBook(Reader reader) {
        try {
            List<Book> listReadBook = em.createQuery("SELECT h.book FROM History h WHERE h.reader = :reader AND h.returnDate=null")
                    .setParameter("reader", reader)
                    .getResultList();
            return listReadBook;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
