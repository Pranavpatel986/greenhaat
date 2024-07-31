package com.greenhaat.security_client.exceptions;

public class SecurityClientException extends RuntimeException{
    public SecurityClientException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SecurityClientException(String exMessage) {
        super(exMessage);
    }
}
