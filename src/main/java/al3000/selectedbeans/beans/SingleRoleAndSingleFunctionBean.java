package al3000.selectedbeans.beans;

import al3000.selectedbeans.Administrator;
import al3000.selectedbeans.OnRequestReceived;
import al3000.selectedbeans.RequestModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Administrator
@OnRequestReceived
public class SingleRoleAndSingleFunctionBean implements Function<RequestModel, RequestModel> {
    @Override
    public RequestModel apply(RequestModel requestModel) {
        return requestModel;
    }
}
