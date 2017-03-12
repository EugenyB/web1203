package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by yevge on 12.03.2017.
 */
@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "YEAR")
    private Integer year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name) &&
                Objects.equals(year, author.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year);
    }

    private Collection<Book> books;

    @OneToMany(mappedBy = "author")
    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
