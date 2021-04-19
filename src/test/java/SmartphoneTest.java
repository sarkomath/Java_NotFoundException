import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Manager;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SmartphoneTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Product product = new Smartphone();

    @Test
    public void removeIfNotExist() {
        int idToRemove = 88;

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

        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }

    @Test
    public void removeIfExist() {
        int idToRemove = 55;

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

        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }
}
