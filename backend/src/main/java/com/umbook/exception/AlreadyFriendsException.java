package com.umbook.exception;

public class AlreadyFriendsException extends RuntimeException {
    public AlreadyFriendsException() {
        super("Ya son amigos.");
    }
    public AlreadyFriendsException(String message) {
        super(message);
    }
}
