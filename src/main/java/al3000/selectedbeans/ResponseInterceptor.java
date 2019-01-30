package al3000.selectedbeans;

public interface ResponseInterceptor<T> {

    T onBeforeResponseSent(T response);

}
