package beans;

import dao.AuthorDAO;
import tables.Author;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yevge on 12.03.2017.
 */
@Named
@RequestScoped
public class AuthorBean {
    @EJB
    AuthorDAO authorDAO;

    public List<Author> getAuthors() {
        return authorDAO.findAll();
    }


}
