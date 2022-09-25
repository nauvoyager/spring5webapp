package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
 // If you add Entity annotation, it will tell Hibernate that this is an Entity class (for mapping)
 //Once annotation is added,it expects  primary key so Id comes in
 //Then we set it with Generation type as Auto meaning the Id is generated form the database
 // (similar to mySQL generating primary key Ids)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany (mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    //No- arg constructor needed for JPA/Hibernate
    //Even in servlets
    //Find reason here https://javarevisited.blogspot.com/2014/01/why-default-or-no-argument-constructor-java-class.html#axzz7bC17BIBb
    public Author(){

    }
   /* public Author(String firstName,String lastName,Set<Book> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }*/
    public Author(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Private properties need getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
