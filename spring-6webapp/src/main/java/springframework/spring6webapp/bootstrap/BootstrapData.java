package springframework.spring6webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.domain.Publisher;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;
import springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author eric = createAuthor("Eric", "Evans");
        Book ddd = createBook("Domain Driven Design", "123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        Author rod = createAuthor("Rod", "Johnson");
        Book noEJB = createBook("J2EEE Development without DJB", "789123");


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        this.authorRepository.save(rod);
        this.bookRepository.save(noEJB);

        Publisher publisher = createPublisher("Publisher name",
                "Sofia",
                "Some state",
                "Center 123",
                "123456");
        Publisher savedPublisher = this.publisherRepository.save(publisher);
        ddd.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("In Bootstrap");
        System.out.println("Author count " + this.authorRepository.count());
        System.out.println("Book count " + this.bookRepository.count());
        System.out.println("Publisher count " + this.publisherRepository.count());
    }

    private Author createAuthor(String firstName,
                                String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }

    private Book createBook(String title,
                                   String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        return book;
    }

    private Publisher createPublisher(String name,
                                             String city,
                                             String state,
                                             String address,
                                             String zipCode) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setCity(city);
        publisher.setState(state);
        publisher.setAddress(address);
        publisher.setZipCode(zipCode);
        return publisher;
    }
}
