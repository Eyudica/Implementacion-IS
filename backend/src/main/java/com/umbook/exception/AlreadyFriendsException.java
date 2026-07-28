package com.umbook.exception;

public class AlreadyFriendsException extends RuntimeException {
    public AlreadyFriendsException() {
        super("Los usuarios ya son amigos");
    }
    public AlreadyFriendsException(String message) {
        super(message);
    }
}
