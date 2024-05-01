import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_CalcDifferentOperationFuzzTarget {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAACdwQAAAACc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAABC5zcQB+AAIAAAC8eA==");

    public static void main(String[] args) throws Throwable {
        Crash_CalcDifferentOperationFuzzTarget.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = ru.hse.CalcDifferentOperationFuzzTarget.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = ru.hse.CalcDifferentOperationFuzzTarget.class.getMethod("fuzzerInitialize", String[].class);
                fuzzerInitialize.invoke(null, (Object) args);
            } catch (NoSuchMethodException ignored1) {
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }
        com.code_intelligence.jazzer.api.CannedFuzzedDataProvider input = new com.code_intelligence.jazzer.api.CannedFuzzedDataProvider(base64Bytes);
        ru.hse.CalcDifferentOperationFuzzTarget.fuzzerTestOneInput(input);
    }
}