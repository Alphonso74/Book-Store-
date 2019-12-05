package mobyDickensBookStore.bootstrap;

import mobyDickensBookStore.model.Genre;
import mobyDickensBookStore.repository.ApplicationUserRepository;
import mobyDickensBookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //
        //  Add some users!
        applicationUserRepository.addUser(324, "admin", "123456", Boolean.TRUE);
        applicationUserRepository.addUser(322, "Alphonso", "Mckenzie", Boolean.FALSE);


        //
        //  Add some games
//        bookRepository.addBook(167890, "The cat with the gat", 234253, "Alphonso Mckenzie", 3101997,10.00, String.valueOf(Genre.CHILDREN));
//        bookRepository.addBook(12340, "Horton hears a poo  ", 123253, "Alphonso Mckenzie", 5201997,15.00, String.valueOf(Genre.CHILDREN));
//        bookRepository.addBook(167890, "50 Shades of Hay", 4344253, "Alphonso Mckenzie", 6161997,12.00, String.valueOf(Genre.ROMANCE));
//        bookRepository.addBook(167890, "Wheres Ronaldo", 234253, "Alphonso Mckenzie", 3101995,10.00, String.valueOf(Genre.CHILDREN));
//        bookRepository.addBook(167890, "ICry", 64355, "Alphonso Mckenzie ", 3101998,10.00, String.valueOf(Genre.CHILDREN));
//        bookRepository.addBook(167890, "Green Eggs and lamb", 753323, "Alphonso Mckenzie", 3102000,13.00, String.valueOf(Genre.CHILDREN));
//        bookRepository.addBook(167890, "The boy who cried Trump", 432346, "Alphonso Mckenzie", 3101964,17.00, String.valueOf(Genre.CLASSICS));
//        bookRepository.addBook(167890, " Hunger Games: The true life saga", 6242434, "Alphonso Mckenzie", 3101800,19.00, String.valueOf(Genre.ADVENTURE));
//        bookRepository.addBook(167890, "Twilight: I suck yo blood", 854355, "Alphonso Mckenzie", 3101801,13.00, String.valueOf(Genre.ROMANCE));
    }
}
