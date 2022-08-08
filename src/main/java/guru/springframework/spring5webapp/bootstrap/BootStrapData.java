package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Used for DI, will tell Spring to scan for dependencies
//Enables the use of other annotations- @Service, @Repository and @Controller
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Author author1 = new Author("Charles", "Duhigg");
        Book book1 = new Book("Power of Habit","xxxyyy");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        Author author2 = new Author("Richard", "Carlson");
        Book book2 = new Book("Dont Sweat the small stuff","aaabbb");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author1);
        bookRepository.save(book1);
        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books "+bookRepository.count());
    }
}
