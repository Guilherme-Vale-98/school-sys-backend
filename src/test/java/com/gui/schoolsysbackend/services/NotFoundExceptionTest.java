package com.gui.schoolsysbackend.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotFoundExceptionTest {

    @Test
    public void testDefaultConstructor() {
        NotFoundException exception = new NotFoundException();
        assertNotNull(exception);
        assertNull(exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String message = "Custom message for NotFoundException";
        NotFoundException exception = new NotFoundException(message);
        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testMessageAndCauseConstructor() {
        String message = "Custom message for NotFoundException";
        Throwable cause = new RuntimeException("Cause for NotFoundException");
        NotFoundException exception = new NotFoundException(message, cause);
        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testCauseConstructor() {
        Throwable cause = new RuntimeException("Cause for NotFoundException");
        NotFoundException exception = new NotFoundException(cause);
        assertNotNull(exception);
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testFullConstructor() {
        String message = "Custom message for NotFoundException";
        Throwable cause = new RuntimeException("Cause for NotFoundException");
        boolean enableSuppression = true;
        boolean writableStackTrace = true;
        NotFoundException exception = new NotFoundException(message, cause, enableSuppression, writableStackTrace);
        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertEquals(enableSuppression, exception.getSuppressed().length == 0);
    }
}
