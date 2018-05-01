import com.company.library.bean.Book;
import com.company.library.dao.BookDAO;
import com.company.library.dao.DbBookDao;
import com.company.library.dao.exception.DaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookDaoTest {

    private BookDAO bookDAO;
    private Book book;

    @Before
    public void init() {

        bookDAO = new DbBookDao();
        book = new Book();
        book.setId(5);
        book.setName("harry potter");
    }

    @Test
    public void getAccount() {

        try {

            Book b = bookDAO.getBookById(book.getId());
            Assert.assertTrue(b.getName().equals(book.getName()));
        }
        catch (DaoException e) {

            e.printStackTrace();
        }
    }
}
