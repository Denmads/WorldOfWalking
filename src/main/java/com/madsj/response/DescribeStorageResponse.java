package com.madsj.response;

import com.madsj.ItemStorage;
import com.madsj.item.description.ItemDescription;
import com.madsj.item.instance.StorageItemInstance;

import java.util.Map;

public class DescribeStorageResponse implements Response {

    private final StorageItemInstance storage;

    public DescribeStorageResponse(StorageItemInstance storage) {
        this.storage = storage;
    }

    @Override
    public void print() {
        if (storage.getItemStorage().itemCount() == 0) {
            System.out.println("The " + storage.getType().getName() + " does not contain any items!");
        }
        else {
            System.out.println("The " + storage.getType().getName() + " contains the following:");
            for (Map.Entry<ItemDescription, Integer> row : storage.getItemStorage().getItemTypeCounts().entrySet()) {
                System.out.println("\t" + row.getKey().getName() + " - " + row.getValue());
            }
        }
    }
}
