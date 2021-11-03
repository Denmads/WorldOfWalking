package com.madsj.exception;

import com.madsj.item.description.ItemDescription;

public class ItemNotInStorageException extends Exception {
    public ItemNotInStorageException(ItemDescription itemDescription) {
        super("The item '" + itemDescription.getName() + "' is not found in the storage!");
    }
}
