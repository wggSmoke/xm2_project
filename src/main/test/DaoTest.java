import com.igeek.dao.UserDao;
import com.igeek.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class DaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User user = userDao.findByName("tom");
        System.out.println(user.getPassword());
    }
}
