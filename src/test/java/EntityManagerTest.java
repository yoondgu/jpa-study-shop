import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpashop.domain.Album;
import jpashop.domain.Book;
import jpashop.domain.Item;
import jpashop.domain.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityManagerTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void 상속관계_매핑() {
        runWithoutCommit(entityManager, entityManager -> {
            Item book = new Book("JPA", 30000, 100, "김영한", "aaaa");
            Item movie = new Movie("바람과함께사라지다", 8000, 1, "감독", "배우");
            Item album = new Album("Time and trace", 18000, 1, "하현상", null);

            entityManager.persist(book);
            entityManager.persist(movie);
            entityManager.persist(album);

            final Book findBook = entityManager.find(Book.class, 1L);
            final Movie findMovie = entityManager.find(Movie.class, 2L);
            final Album findAlbum = entityManager.find(Album.class, 3L);

            System.out.println("book author=" + findBook.getAuthor());
            System.out.println("movie director=" + findMovie.getDirector());
            System.out.println("album artist=" + findAlbum.getArtist());
        });
    }

    private static void runWithoutCommit(EntityManager entityManager, final Consumer<EntityManager> callback) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            callback.accept(entityManager);
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage());
        } finally {
            transaction.rollback();
        }
    }
}
