import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Manager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SmartphoneTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Product product = new Smartphone();

    @Test
    public void searchSmartphoneByFabricator() {
        Smartphone smartphone1 = new Smartphone(11, 111, "Phone1", "Fabric1");
        Smartphone smartphone2 = new Smartphone(22, 111, "Phone2", "Fabric1");
        Smartphone smartphone3 = new Smartphone(33, 222, "Phone3", "Fabric2");
        Smartphone smartphone4 = new Smartphone(44, 222, "Phone4", "Fabric2");
        Smartphone smartphone5 = new Smartphone(55, 333, "Phone5", "Fabric3");
        Smartphone smartphone6 = new Smartphone(66, 444, "Phone6", "Fabric4");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);

        Product[] actual = manager.searchBy("Fabric2");
        Product[] expected = new Product[]{smartphone3, smartphone4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        Smartphone smartphone1 = new Smartphone(11, 111, "Phone11", "Fabric11");
        Smartphone smartphone2 = new Smartphone(22, 111, "Phone22", "Fabric11");
        Smartphone smartphone3 = new Smartphone(33, 222, "Phone33", "Fabric22");
        Smartphone smartphone4 = new Smartphone(44, 222, "Phone44", "Fabric22");
        Smartphone smartphone5 = new Smartphone(55, 333, "Phone55", "Fabric33");
        Smartphone smartphone6 = new Smartphone(66, 444, "Phone66", "Fabric44");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);

        Product[] actual = manager.searchBy("Phone66");
        Product[] expected = new Product[]{smartphone6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void NoFindPhones() {
        Smartphone smartphone1 = new Smartphone(11, 111, "Phone111", "Fabric111");
        Smartphone smartphone2 = new Smartphone(22, 111, "Phone222", "Fabric111");
        Smartphone smartphone3 = new Smartphone(33, 222, "Phone333", "Fabric222");
        Smartphone smartphone4 = new Smartphone(44, 222, "Phone444", "Fabric222");
        Smartphone smartphone5 = new Smartphone(55, 333, "Phone555", "Fabric333");
        Smartphone smartphone6 = new Smartphone(66, 444, "Phone666", "Fabric444");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);

        Product[] actual = manager.searchBy("iPhone6");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void PhoneIdRemove() {
        int idToRemove = 44;

        Smartphone smartphone1 = new Smartphone(11, 111, "Phone111", "Fabric111");
        Smartphone smartphone2 = new Smartphone(22, 111, "Phone222", "Fabric111");
        Smartphone smartphone3 = new Smartphone(33, 222, "Phone333", "Fabric222");
        Smartphone smartphone4 = new Smartphone(44, 222, "Phone444", "Fabric222");
        Smartphone smartphone5 = new Smartphone(55, 333, "Phone555", "Fabric333");
        Smartphone smartphone6 = new Smartphone(66, 444, "Phone666", "Fabric444");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);

        repository.removeById(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3, smartphone5, smartphone6};
    }
}
