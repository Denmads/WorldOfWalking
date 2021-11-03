package com.madsj.item.description;

import com.madsj.LevelObjects;
import com.madsj.item.instance.ItemInstance;
import com.madsj.item.instance.StorageItemInstance;

import java.util.UUID;

public class StorageItemDescription extends ItemDescription {

    private int capacity;

    public StorageItemDescription(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public ItemInstance createInstance() {
        UUID storageId = LevelObjects.getStorageDB().createStorage(this.capacity);
        return new StorageItemInstance(this, storageId);
    }
}
