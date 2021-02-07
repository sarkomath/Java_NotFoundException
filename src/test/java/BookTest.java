import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.repository.Manager;
import ru.netology.repository.Repository;


import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Product product = new Book();

    @Test
    public void searchBookByName() {
        Book book1 = new Book(1, 111, "Book1", "Author11");
        Book book2 = new Book(2, 222, "Book2", "Author22");
        Book book3 = new Book(3, 333, "Book3", "Author11");
        Book book4 = new Book(4, 444, "Book4", "Author44");
        Book book5 = new Book(5, 111, "Book2", "Author55");
        Book book6 = new Book(6, 222, "Book6", "Author66");
        Book book7 = new Book(7, 333, "Book2", "Author11");
        Book book8 = new Book(8, 444, "Book8", "Author88");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchBookByAuthor() {
        Book book1 = new Book(1, 111, "Book11", "Author1");
        Book book2 = new Book(2, 222, "Book22", "Author2");
        Book book3 = new Book(3, 333, "Book33", "Author1");
        Book book4 = new Book(4, 444, "Book44", "Author4");
        Book book5 = new Book(5, 111, "Book22", "Author5");
        Book book6 = new Book(6, 222, "Book66", "Author6");
        Book book7 = new Book(7, 333, "Book22", "Author1");
        Book book8 = new Book(8, 444, "Book88", "Author8");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] actual = manager.searchBy("Author1");
        Product[] expected = new Product[]{book1, book3, book7};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void NoFindBookTest() {
        Book book1 = new Book(1, 111, "Book111", "Author1");
        Book book2 = new Book(2, 222, "Book222", "Author2");
        Book book3 = new Book(3, 333, "Book333", "Author1");
        Book book4 = new Book(4, 444, "Book444", "Author4");
        Book book5 = new Book(5, 111, "Book222", "Author5");
        Book book6 = new Book(6, 222, "Book666", "Author6");
        Book book7 = new Book(7, 333, "Book222", "Author1");
        Book book8 = new Book(8, 444, "Book888", "Author8");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] actual = manager.searchBy("There_is_No_Book");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void BookIdRemove() {
        int idToRemove = 101;

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

        repository.removeById(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2, book3, book4, book5, book6, book7, book8};
    }
}
