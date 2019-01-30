package al3000.selectedbeans;

public interface RequestInterceptor<T> {

    T onRequestReceived(T request);
}
