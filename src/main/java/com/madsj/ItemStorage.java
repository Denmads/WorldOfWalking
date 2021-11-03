package com.madsj;

import com.madsj.exception.ItemNotInStorageException;
import com.madsj.exception.NotEnoughSpaceInStorageException;
import com.madsj.exception.TooFewItemsInStorageException;
import com.madsj.item.description.ItemDescription;
import com.madsj.item.instance.ItemInstance;

import java.util.*;

public class ItemStorage implements Iterable<Map.Entry<ItemDescription, Integer>> {
    private List<ItemInstance> items = new ArrayList<>();
    private int limit; //-1 for infinite

    public ItemStorage() {
        this(-1);
    }

    public ItemStorage(int limit) {
        this.limit = limit;
    }

    public int itemCount() {
        return items.size();
    }

    public int itemCount(ItemDescription type) {
        int numItems = 0;
        for (ItemInstance item : items) {
            if (item.getType() == type) numItems++;
        }
        return numItems;
    }

    public int freeSpace() {
        return itemCount() - (limited() ? limit : Integer.MAX_VALUE);
    }

    public int totalSpace() {
        return limited() ? limit : Integer.MAX_VALUE;
    }

    public boolean limited() {
        return limit != -1;
    }

    public void addItem(ItemInstance item) throws NotEnoughSpaceInStorageException {
        if (freeSpace() < amount) {
            throw new NotEnoughSpaceInStorageException(freeSpace(), amount);
        }

        if (items.containsKey(type)) {
            items.replace(type, items.get(type) + amount);
        }
        else {
            items.put(type, amount);
        }
    }

    public void addItems(List<ItemInstance> items) {
        
    }

    public void removeItem(ItemDescription type, int amount) throws ItemNotInStorageException, TooFewItemsInStorageException {
        if (!items.containsKey(type)) {
            throw new ItemNotInStorageException(type);
        }
        else if (items.get(type) < amount) {
            throw new TooFewItemsInStorageException(type, amount, items.get(type));
        }

        items.replace(type, items.get(type) - amount);
        if (items.get(type) == 0) {
            items.remove(type);
        }
    }

    public void transferItemTo(ItemStorage other, ItemDescription type, int amount) throws ItemNotInStorageException, TooFewItemsInStorageException, NotEnoughSpaceInStorageException {
        removeItem(type, amount);
        other.addItem(type, amount);
    }

    @Override
    public Iterator<Map.Entry<ItemDescription, Integer>> iterator() {
        return items.entrySet().iterator();
    }
}
