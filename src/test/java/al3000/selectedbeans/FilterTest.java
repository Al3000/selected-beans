package al3000.selectedbeans;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static al3000.selectedbeans.SelectionTest.log;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FilterTest {

    @Autowired
    @Qualifier2
    List<RequestInterceptor<?>> requestInterceptors;

    @Autowired
    @Qualifier2
    List<RequestInterceptor<RequestModel1>> typedRequestInterceptors;

    @Autowired
    @Qualifier2
    List<ResponseInterceptor<?>> responseInterceptors;

    @Test
    public void shouldFilterQualifiedBeansAlsoByType() {
        assertNotNull(requestInterceptors);
        log("shouldFilterQualifiedBeansAlsoByType()", requestInterceptors);
        assertSame(2, requestInterceptors.size());
    }

    @Test
    public void shouldFilterQualifiedBeansAlsoByTypeParameter() {
        assertNotNull(typedRequestInterceptors);
        log("shouldFilterQualifiedBeansAlsoByTypeParameter()", typedRequestInterceptors);
        assertSame("expected to fail.\n", 1, typedRequestInterceptors.size());
    }

    @Test
    public void selectorsShouldNotInterfereWhenTyped() {
        assertNotNull(responseInterceptors);
        log("selectorsShouldNotInterfere()", responseInterceptors);
        Assert.assertSame(1, responseInterceptors.size());
    }
}
