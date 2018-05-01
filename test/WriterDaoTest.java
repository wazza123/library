import com.company.library.bean.Writer;
import com.company.library.dao.DbWriterDao;
import com.company.library.dao.WriterDao;
import com.company.library.dao.exception.DaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterDaoTest {

    WriterDao writerDao;
    Writer writer;

    @Before
    public void init() {

        writerDao = new DbWriterDao();
        writer = new Writer();
        writer.setId(4);
        writer.setFirstName("j.");
        writer.setLastName("rouling");
    }

    @Test
    public void getWriter() {

        try {

            Writer w = writerDao.getWriterById(writer.getId());
            Assert.assertTrue(w.getFirstName().equals(writer.getFirstName()));
            Assert.assertTrue(w.getLastName().equals(writer.getLastName()));
        }
        catch (DaoException e) {

            e.printStackTrace();
        }
    }

}
