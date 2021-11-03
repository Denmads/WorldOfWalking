package com.madsj.exception;

import com.madsj.item.description.ItemDescription;

public class TooFewItemsInStorageException extends Exception {
    public TooFewItemsInStorageException(ItemDescription itemDescription, int required, int actual) {
        super("Not enough items in the storage! Required: " + required + " | Available: " + actual);
    }
}
