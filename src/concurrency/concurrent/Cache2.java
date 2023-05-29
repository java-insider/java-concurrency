package concurrency.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cache2 {

    private static final Cache2 INSTANCE = new Cache2();

    private final ConcurrentMap<String, String> data = new ConcurrentHashMap<>();

    private Cache2() {}

    public static Cache2 getInstance() {
        return INSTANCE;
    }

    public String get(String property) {
        return data.get(property);
    }

    public void set(String property, String value) {
        data.put(property, value);
    }
}
