import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.repository.Manager;
import ru.netology.repository.Repository;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ProductManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);

    Book book1 = new Book(1, 111, "Book1", "Author1");
    Book book2 = new Book(2, 222, "Book2", "Author2");
    Book book3 = new Book(3, 333, "Book3", "Author1");
    Book book4 = new Book(4, 444, "Book4", "Author4");
    Book book5 = new Book(5, 111, "Book2", "Author5");
    Book book6 = new Book(6, 222, "Book6", "Author6");
    Book book7 = new Book(7, 333, "Book2", "Author1");
    Book book8 = new Book(8, 444, "Book8", "Author8");

    Smartphone smartphone1 = new Smartphone(11, 111, "Phone1", "Fabric1");
    Smartphone smartphone2 = new Smartphone(22, 111, "Phone2", "Fabric1");
    Smartphone smartphone3 = new Smartphone(33, 222, "Phone3", "Fabric2");
    Smartphone smartphone4 = new Smartphone(44, 222, "Phone4", "Fabric2");
    Smartphone smartphone5 = new Smartphone(55, 333, "Phone5", "Fabric3");
    Smartphone smartphone6 = new Smartphone(66, 444, "Phone6", "Fabric4");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);
    }

    // Book Test
    @Test
    public void searchBookByAuthor() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Book();

        Product[] actual = manager.searchBy("Author1");
        Product[] expected = new Product[]{book1, book3, book7};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchBookByName() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Book();

        Product[] actual = manager.searchBy("Book8");
        Product[] expected = new Product[]{book8};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void NoFindBookTest() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Book();

        Product[] actual = manager.searchBy("Book22");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void BookIdRemove() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book8, book7, book6, book5, book4, book3, book2};
    }

    // Smartphone test

    @Test
    public void searchSmartphoneByFabricator() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Smartphone();

        Product[] actual = manager.searchBy("Fabric2");
        Product[] expected = new Product[]{smartphone3, smartphone4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Smartphone();

        Product[] actual = manager.searchBy("phone6");
        Product[] expected = new Product[]{smartphone6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void NoFindPhones() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Smartphone();

        Product[] actual = manager.searchBy("iPhone6");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}
