package com.madsj.item.instance;

import com.madsj.ItemStorage;
import com.madsj.LevelObjects;
import com.madsj.item.description.ItemDescription;

import java.util.UUID;

public class StorageItemInstance extends ItemInstance{
    private ItemDescription type;
    private UUID storageId;

    public StorageItemInstance(ItemDescription type, UUID storageId) {
        super(type);
        this.storageId = storageId;
    }

    public ItemDescription getType() {
        return type;
    }

    public ItemStorage getItemStorage() {
        return LevelObjects.getStorageDB().getById(storageId);
    }
}
