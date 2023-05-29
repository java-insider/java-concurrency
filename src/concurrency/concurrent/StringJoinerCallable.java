package concurrency.concurrent;

import java.util.List;
import java.util.concurrent.Callable;

public class StringJoinerCallable implements Callable<String> {

    private final List<String> strings;

    public StringJoinerCallable(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public String call() {
        return String.join("", strings);
    }
}
