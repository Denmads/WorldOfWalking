package com.madsj.item.instance;

import com.madsj.item.description.ItemDescription;

public class ItemInstance {
    private ItemDescription type;

    public ItemInstance(ItemDescription type) {
        this.type = type;
    }

    public ItemDescription getType() {
        return type;
    }
}
