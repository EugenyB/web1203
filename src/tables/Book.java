package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by yevge on 12.03.2017.
 */
@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "PAGES")
    private Integer pages;
    @Basic
    @Column(name = "ARTICLE")
    private String article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(pages, book.pages) &&
                Objects.equals(article, book.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pages, article);
    }

    private Author author;

    @ManyToOne(optional = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    private Collection<Genre> genres;

    @ManyToMany(mappedBy = "books")
    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }
}
