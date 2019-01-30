package al3000.selectedbeans.beans;

import al3000.selectedbeans.Qualifier2;
import al3000.selectedbeans.ResponseInterceptor;
import al3000.selectedbeans.ResponseModel;
import org.springframework.stereotype.Component;

@Component
@Qualifier2
public class QualifiedResponseInterceptor implements ResponseInterceptor<ResponseModel> {
    @Override
    public ResponseModel onBeforeResponseSent(ResponseModel response) {
        return response;
    }
}
