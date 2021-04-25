import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.repository.Manager;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.Repository;


import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Product product = new Book();

    @Test
    public void removeIfNotExist() {

        Book book1 = new Book(101, 111, "Book111", "Author1");
        Book book2 = new Book(202, 222, "Book222", "Author2");
        Book book3 = new Book(303, 333, "Book333", "Author1");
        Book book4 = new Book(404, 444, "Book444", "Author4");
        Book book5 = new Book(505, 111, "Book222", "Author5");
        Book book6 = new Book(606, 222, "Book666", "Author6");
        Book book7 = new Book(707, 333, "Book222", "Author1");
        Book book8 = new Book(808, 444, "Book888", "Author8");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        assertThrows(NotFoundException.class, () -> repository.removeById(999));
    }

    @Test
    public void removeIfExist() {

        Book book1 = new Book(101, 111, "Book111", "Author1");
        Book book2 = new Book(202, 222, "Book222", "Author2");
        Book book3 = new Book(303, 333, "Book333", "Author1");
        Book book4 = new Book(404, 444, "Book444", "Author4");
        Book book5 = new Book(505, 111, "Book222", "Author5");
        Book book6 = new Book(606, 222, "Book666", "Author6");
        Book book7 = new Book(707, 333, "Book222", "Author1");
        Book book8 = new Book(808, 444, "Book888", "Author8");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        repository.removeById(707);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, book4, book5, book6, book8};
    }
}
