package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the Rings", 150, "Tolkien");
        Book book2 = new Book(2, "War and Peace", 200, "Tolstoy");
        Book book3 = new Book(3, "Lord of the Rings 2", 300, "Tolkien");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the Rings", 150, "Tolkien");
        Book book2 = new Book(2, "War and Peace", 200, "Tolstoy");
        Book book3 = new Book(3, "Lord of the Rings 2", 300, "Tolkien");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Lord of the Rings");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the Rings", 150, "Tolkien");
        Book book2 = new Book(2, "War and Peace", 200, "Tolstoy");
        Book book3 = new Book(3, "Lord of the Rings 2", 300, "Tolkien");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("War and Peace");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenNonProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the Rings", 150, "Tolkien");
        Book book2 = new Book(2, "War and Peace", 200, "Tolstoy");
        Book book3 = new Book(3, "Lord of the Rings 2", 300, "Tolkien");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}