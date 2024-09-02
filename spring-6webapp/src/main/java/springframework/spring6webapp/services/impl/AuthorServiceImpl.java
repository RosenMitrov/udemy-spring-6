package springframework.spring6webapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
