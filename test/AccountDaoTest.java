import com.company.library.bean.Account;
import com.company.library.dao.AccountDAO;
import com.company.library.dao.DbAccountDao;
import com.company.library.dao.exception.DaoException;
import com.company.library.service.StringEncoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest {

    private AccountDAO accountDAO;
    private Account account;

    @Before
    public void init() {

        accountDAO = new DbAccountDao();
        account = new Account();
        account.setLogin("admin");
        account.setPassword(StringEncoder.encodeString("admin"));
    }

    @Test
    public void getAccount() {

        try {

            Account acc = accountDAO.getAccount("admin");
            Assert.assertTrue(acc.getLogin().equals(account.getLogin()));
            Assert.assertTrue(acc.getPassword().equals(account.getPassword()));
        }
        catch (DaoException e) {

            e.printStackTrace();
        }
    }

}
