package dao;

import tables.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yevge on 12.03.2017.
 */
@Stateless
public class AuthorDAO {
    @PersistenceContext
    EntityManager em;

    public List<Author> findAll() {
        return em.createQuery("select a from Author a").getResultList();
    }

    public Author create(Author a) {
        em.persist(a);
        return a;
    }
}
