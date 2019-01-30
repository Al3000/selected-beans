package al3000.selectedbeans.beans;

import al3000.selectedbeans.Qualifier2;
import al3000.selectedbeans.RequestInterceptor;
import al3000.selectedbeans.RequestModel1;
import org.springframework.stereotype.Component;

@Component
@Qualifier2
public class QualifiedRequestInterceptor implements RequestInterceptor<RequestModel1> {
    @Override
    public RequestModel1 onRequestReceived(RequestModel1 request) {
        return request;
    }
}
