package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public void testDeletionWhenProductExists() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the Rings", 150, "Tolkien");
        Book book2 = new Book(2, "War and Peace", 200, "Tolstoy");
        Book book3 = new Book(3, "Lord of the Rings 2", 300, "Tolkien");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

}