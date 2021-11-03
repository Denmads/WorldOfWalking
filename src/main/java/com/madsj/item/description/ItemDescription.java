package com.madsj.item.description;

import com.madsj.Level;
import com.madsj.LevelObjects;
import com.madsj.item.instance.ItemInstance;

import java.util.UUID;

public class ItemDescription {
    private UUID id;
    private String name;

    public ItemDescription(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemInstance createInstance() {
        return new ItemInstance(this);
    }
}
