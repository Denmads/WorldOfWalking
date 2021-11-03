package com.madsj;

import com.madsj.item.description.ItemDescription;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageDictionary {
    private Map<UUID, ItemStorage> idToStorageMap = new HashMap<>();

    public UUID createStorage(int capacity) {
        ItemStorage storage = new ItemStorage(capacity);
        return add(storage);
    }

    public UUID add(ItemStorage storage) {
        UUID id = UUID.randomUUID();
        idToStorageMap.put(id, storage);
        return id;
    }

    public void remove(UUID id) {
        idToStorageMap.remove(id);
    }

    public ItemStorage getById(UUID id) {
        return idToStorageMap.get(id);
    }
}
