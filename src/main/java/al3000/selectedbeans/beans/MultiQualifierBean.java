package al3000.selectedbeans.beans;

import al3000.selectedbeans.Qualifier1;
import al3000.selectedbeans.Qualifier2;
import org.springframework.stereotype.Component;

@Component
@Qualifier1
@Qualifier2
public class MultiQualifierBean {
}
