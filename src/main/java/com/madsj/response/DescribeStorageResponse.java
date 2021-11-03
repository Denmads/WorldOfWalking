package com.madsj.response;

import com.madsj.ItemStorage;
import com.madsj.item.description.ItemDescription;

import java.util.Map;

public class DescribeStorageResponse implements Response {

    private final String name;
    private final ItemStorage storage;

    public DescribeStorageResponse(String storageName, ItemStorage storage) {
        this.storage = storage;
        this.name = storageName;
    }

    @Override
    public void print() {
        System.out.println("The " + name + " contains the following:");
        for (Map.Entry<ItemDescription, Integer> row : storage) {
            ItemDescription type = storage.getLevel().getItemDB().getById(row.getKey().getId());
            System.out.println("\t" + type.getName() + " - " + row.getValue());
        }
    }
}
