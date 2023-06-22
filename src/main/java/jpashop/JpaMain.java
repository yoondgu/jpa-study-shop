package jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpashop.domain.Album;
import jpashop.domain.Book;
import jpashop.domain.Item;
import jpashop.domain.Movie;

public class JpaMain {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        final EntityManager em = emf.createEntityManager();

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Item book = new Book("JPA", 30000, 100, "김영한", "aaaa");
            Item movie = new Movie("바람과함께사라지다", 8000, 1, "감독", "배우");
            Item album = new Album("Time and trace", 18000, 1, "하현상", null);

            em.persist(book);
            em.persist(movie);
            em.persist(album);

            final Book findBook = em.find(Book.class, 1L);
            final Movie findMovie = em.find(Movie.class, 2L);
            final Album findAlbum = em.find(Album.class, 3L);

            System.out.println("book author=" + findBook.getAuthor());
            System.out.println("movie director=" + findMovie.getDirector());
            System.out.println("album artist=" + findAlbum.getArtist());

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
