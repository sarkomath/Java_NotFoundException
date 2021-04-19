package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.Manager;


public class Repository {
    private static Product[] items = new Product[0];

    // сохранение продукта
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // search all
    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }

    // delete by id
    public void removeById(int id) {
        Product prod = findById(id);
        if (prod == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
