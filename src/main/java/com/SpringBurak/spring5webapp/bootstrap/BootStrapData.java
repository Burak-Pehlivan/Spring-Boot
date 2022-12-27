package com.SpringBurak.spring5webapp.bootstrap;

import com.SpringBurak.spring5webapp.domain.Author;
import com.SpringBurak.spring5webapp.domain.Book;
import com.SpringBurak.spring5webapp.domain.Publisher;
import com.SpringBurak.spring5webapp.repositories.AuthorRepository;
import com.SpringBurak.spring5webapp.repositories.BookRepository;
import com.SpringBurak.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author Burak = new Author("Pehlivan","Fatih");
        Book explain = new Book("BDD","123451");
        Burak.getBooks().add(explain);
        explain.getAuthors().add(Burak);

        explain.setPublisher(publisher);
        publisher.getBooks().add(explain);

        authorRepository.save(Burak);
        bookRepository.save(explain);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "324236125");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
