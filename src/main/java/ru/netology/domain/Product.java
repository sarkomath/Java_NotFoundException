package ru.netology.domain;

import java.util.Objects;

public class Product {
  private int id;
  private String name;
  private int price;
// созданы геттеры, сеттеры, конструкторы
  public Product() {
  }

  public Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) { // проверка объектов на равенство
    if (this == o) return true; // ерли ексит - если ссылки совпадают то ничего больше не надо проверять.
    if (o == null || getClass() != o.getClass()) return false; // если нет - проверяем объекты на отношение их к одному классу.
    Product product = (Product) o; // приведение типов
    return id == product.id &&
        price == product.price &&
        Objects.equals(name, product.name); // проверка полей на равенство
  }

  @Override
  public int hashCode() { // хэш-код для хранения в структурах данных
    return Objects.hash(id, name, price);
  }

  @Override
  public String toString() { // вывод объекта в строковом представлении
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
