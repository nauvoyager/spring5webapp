package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Used for DI, will tell Spring to scan for dependencies
//Enables the use of other annotations- @Service, @Repository and @Controller
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Author author1 = new Author("Charles", "Duhigg");
        Book book1 = new Book("Power of Habit","xxxyyy");
        Publisher publisher1 = new Publisher("NY publishers","NY street","Manhattan","NY","ny0001");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);


        Author author2 = new Author("Richard", "Carlson");
        Book book2 = new Book("Dont Sweat the small stuff","aaabbb");
        Publisher publisher2 = new Publisher("CA publishers","CA street","California","LA","ca0001");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author1);
        bookRepository.save(book1);
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Number of Authors "+authorRepository.count());
        System.out.println("Number of Publishers "+publisherRepository.count());
    }
}
