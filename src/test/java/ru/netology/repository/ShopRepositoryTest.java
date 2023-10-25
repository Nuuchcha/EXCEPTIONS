package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ShopRepositoryTest {

    Product item1 = new Product(5, "Лейка", 50);
    Product item2 = new Product(2, "Шланг", 387);
    Product item3 = new Product(10, "Ведро", 140);
    Product item4 = new Product(14, "Тример", 500);
    Product item5 = new Product(27, "Кран", 20);

    @Test
    public void shouldDeleteIdProduct(){
        ShopRepository product = new ShopRepository();

        product.add(item1);
        product.add(item2);
        product.add(item3);
        product.add(item4);
        product.add(item5);

        product.remove(10);

        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = product.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDeleteIdProduct(){
        ShopRepository product = new ShopRepository();

        product.add(item1);
        product.add(item2);
        product.add(item3);
        product.add(item4);
        product.add(item5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            product.remove(13);
        });
    }
}
