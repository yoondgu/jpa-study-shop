package jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item {

    private String author;
    private String isbn;

    public Book() {
    }

    public Book(final String name,
                final long price,
                final int stockQuantity,
                final String author,
                final String isbn) {
        super(null, name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
