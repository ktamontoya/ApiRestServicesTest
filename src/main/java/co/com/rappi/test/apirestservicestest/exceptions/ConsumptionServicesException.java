package co.com.rappi.test.apirestservicestest.exceptions;

@SuppressWarnings("serial")
public class ConsumptionServicesException extends AssertionError {
    public ConsumptionServicesException(String message, Throwable cause) {
        super(message, cause);
    }
}