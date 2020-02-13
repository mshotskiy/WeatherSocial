package com.tntu.weather.api.exception;

import java.io.IOException;

public class JsonIsNullException extends IOException {
    public JsonIsNullException(String message) {
        super(message);
    }
}
