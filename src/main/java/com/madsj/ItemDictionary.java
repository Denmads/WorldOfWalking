package com.madsj;

import com.madsj.item.description.ItemDescription;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ItemDictionary {
    private Map<UUID, ItemDescription> idToItemMap = new HashMap<>();
    private Map<String, ItemDescription> nameToItemMap = new HashMap<>();

    public void add(ItemDescription item) {
        if (nameToItemMap.containsKey(item.getName()))
            throw new IllegalArgumentException("Item with name '" + item.getName() + "' already exists in the item dictionary!");

        idToItemMap.put(item.getId(), item);
        nameToItemMap.put(item.getName(), item);
    }

    public ItemDescription getById(UUID id) {
        return idToItemMap.get(id);
    }

    public ItemDescription getByName(String name) {
        return nameToItemMap.get(name);
    }
}
