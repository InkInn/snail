package future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DubFuture<T> extends CompletableFuture<T> {

    private final static Logger LOG = LoggerFactory.getLogger(DubFuture.class);


    private T defaultValue = null;

    private String methodName;

    private Map<String, Object> args;

    @Override
    public T get(long timeout, TimeUnit unit) {
        try {
            return super.get(timeout, unit);
        } catch (Exception e) {

        }
        return defaultValue;
    }


    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }

    public static <U> CompletableFuture<U> supplyAsyncWithDefaultValue(Supplier<U> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }

}
