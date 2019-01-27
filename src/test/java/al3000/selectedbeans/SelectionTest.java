package al3000.selectedbeans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectionTest {

    @Autowired
    @Administrator
    List<Function<?, ?>> adminBeans;

    @Autowired
    @Administrator
    @OnRequestReceived
    List<Function<?, ?>> mixedAdminAndRequestListenerBeans;


    @Test
    public void testAdminAnnotation() {
        assertNotNull(adminBeans);
        for (Function<?, ?> f : adminBeans) {
            System.out.printf("testAdminAnnotation() - %s\n", f.getClass().getSimpleName());
        }
        assertSame(adminBeans.size(), 2);
    }


    @Test
    public void testAdminRequestAnnotationsMix() {
        assertNotNull(mixedAdminAndRequestListenerBeans);
        assertSame(mixedAdminAndRequestListenerBeans.size(), 1);
        for (Function<?, ?> f : mixedAdminAndRequestListenerBeans) {
            System.out.printf("testAdminRequestAnnotationsMix() - %s\n", f.getClass().getSimpleName());
        }
    }
}
