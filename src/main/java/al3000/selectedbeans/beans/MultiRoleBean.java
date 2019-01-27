package al3000.selectedbeans.beans;

import al3000.selectedbeans.Administrator;
import al3000.selectedbeans.RequestModel;
import al3000.selectedbeans.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Administrator
@User
public class MultiRoleBean implements Function<RequestModel, RequestModel> {
    @Override
    public RequestModel apply(RequestModel requestModel) {
        return requestModel;
    }
}
