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


    @Autowired @Administrator List<Function<?, ?>> adminBeans;

    @Autowired
    @Administrator
    @OnRequestReceived
    List<Function<?, ?>> mixedAdminAndRequestListenerBeans;

    @Autowired @Administrator @User List<Function<?, ?>> multiRoleBeans;

    @Autowired @Administrator @User @OnBeforeResponseSent List<Function<?, ?>> multiRoleSingleFuncBeans;


    @Test
    public void testAdminAnnotation() {
        assertNotNull(adminBeans);
        for (Function<?, ?> f : adminBeans) {
            System.out.printf("testAdminAnnotation() - %s\n", f.getClass().getSimpleName());
        }
        assertSame(4, adminBeans.size());
    }


    @Test
    public void testAdminRequestAnnotationsMix() {
        assertNotNull(mixedAdminAndRequestListenerBeans);
        assertSame(1, mixedAdminAndRequestListenerBeans.size());
        for (Function<?, ?> f : mixedAdminAndRequestListenerBeans) {
            System.out.printf("testAdminRequestAnnotationsMix() - %s\n", f.getClass().getSimpleName());
        }
    }

    @Test
    public void testMultiRole() {
        assertNotNull(multiRoleBeans);
        assertSame(2, multiRoleBeans.size());
        for (Function<?, ?> f : multiRoleBeans) {
            System.out.printf("testMultiRole() - %s\n", f.getClass().getSimpleName());
        }
    }

    @Test
    public void testMultiRoleSingleFunction() {
        assertNotNull(multiRoleSingleFuncBeans);
        assertSame(1, multiRoleSingleFuncBeans.size());
        for (Function<?, ?> f : multiRoleSingleFuncBeans) {
            System.out.printf("multiRoleSingleFuncBeans() - %s\n", f.getClass().getSimpleName());
        }
    }
}
