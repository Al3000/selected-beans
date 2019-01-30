package al3000.selectedbeans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectionTest {


    @Autowired
    @Qualifier1
    List<Object> qualifier1Beans;

    @Autowired
    @Qualifier2
    List<Object> qualifier2Beans;

    @Autowired
    @Qualifier1
    @Qualifier2
    List<Object> multiQualifierBeans;

    @Test
    public void shouldSelectAllQualifier1Beans() {
        assertNotNull(qualifier1Beans);
        log("shouldSelectAllQualifier1Beans()", qualifier1Beans);
        assertSame(2, qualifier1Beans.size());
    }

    static void log(String logPrefix, List<?> list) {
        for (Object o: list) {
            System.out.printf("%s - %s\n", logPrefix, o.getClass().getSimpleName());
        }
    }


    @Test
    public void shouldSelectAllQualifier2Beans() {
        assertNotNull(qualifier2Beans);
        log("shouldSelectAllQualifier2Beans()", qualifier2Beans);
        assertSame(4, qualifier2Beans.size());
    }

    @Test
    public void shouldSelectMultiQualifierBeans() {
        assertNotNull(multiQualifierBeans);
        log("shouldSelectMultiQualifierBeans()", multiQualifierBeans);
        assertSame(1, multiQualifierBeans.size());
    }
}
