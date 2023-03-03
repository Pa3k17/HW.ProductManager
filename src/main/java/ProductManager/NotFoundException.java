package ProductManager;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Product with id: " + id + " not found");
    }
}
