package springframework.spring6webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author eric = createAuthor("Eric", "Evans");
        Author ericSaved = this.authorRepository.save(eric);

        Book ddd = createBook("Domain Driven Design", "123456");
        Book dddSaved = this.bookRepository.save(ddd);

        ericSaved.getBooks().add(dddSaved);
        this.authorRepository.save(ericSaved);

        Author rod = createAuthor("Rod", "Johnson");
        Author rodSaved = this.authorRepository.save(rod);

        Book noEJB = createBook("J2EEE Development without DJB", "789123");
        Book noEJBSaved = this.bookRepository.save(noEJB);

        rodSaved.getBooks().add(noEJBSaved);
        this.authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count " + this.authorRepository.count());
        System.out.println("Book count " + this.bookRepository.count());
    }

    private static Book createBook(String title,
                                   String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        return book;
    }

    private Author createAuthor(String firstName,
                                String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }
}
