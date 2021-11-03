package com.madsj.exception;

public class NotEnoughSpaceInStorageException extends Exception {
    public NotEnoughSpaceInStorageException(int freeSpace, int requiredSpace) {
        super("Not enough free space in inventory! Free: " + freeSpace + " | Needed: " + requiredSpace);
    }
}
