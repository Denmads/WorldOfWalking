package com.madsj;

import com.madsj.exception.ItemNotInStorageException;
import com.madsj.exception.NotEnoughSpaceInStorageException;
import com.madsj.exception.TooFewItemsInStorageException;
import com.madsj.item.description.ItemDescription;
import com.madsj.item.instance.ItemInstance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemStorage {
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

    public List<ItemDescription> getStoredItemTypes() {
        return items.stream().map(new Function<ItemInstance, ItemDescription>() {
            @Override
            public ItemDescription apply(ItemInstance itemInstance) {
                return itemInstance.getType();
            }
        }).distinct().collect(Collectors.toList());
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
        if (freeSpace() == 0) {
            throw new NotEnoughSpaceInStorageException(freeSpace(), 1);
        }

        items.add(item);
    }

    public void addItems(List<ItemInstance> items) throws NotEnoughSpaceInStorageException {
        if (freeSpace() < items.size()) {
            throw new NotEnoughSpaceInStorageException(freeSpace(), items.size());
        }

        this.items.addAll(items);
    }

    //Removes a specific item from the storage
    public void removeItem(ItemInstance item) throws ItemNotInStorageException {
        if (!items.contains(item)) {
            throw new ItemNotInStorageException(item.getType());
        }

        items.remove(item);
    }

    //Removes the first 'amount' of the given item type. Returns the removed items
    public List<ItemInstance> removeItems(ItemDescription type, int amount) throws TooFewItemsInStorageException {
        if (itemCount(type) < amount) {
            throw new TooFewItemsInStorageException(type, amount, itemCount(type));
        }

        int index = items.size()-1;
        List<ItemInstance> removed = new ArrayList<>();
        while (amount > 0) {
            ItemInstance item = items.get(index);
            if (item.getType() == type) {
                items.remove(item);
                removed.add(item);
                amount--;
            }

            index--;
        }
        return removed;
    }

    public void transferItemTo(ItemStorage other, ItemInstance item) throws ItemNotInStorageException, NotEnoughSpaceInStorageException {
        removeItem(item);
        other.addItem(item);
    }

    public void transferItemsTo(ItemStorage other, ItemDescription type, int amount) throws TooFewItemsInStorageException, NotEnoughSpaceInStorageException {
        List<ItemInstance> removed = removeItems(type, amount);
        other.addItems(removed);
    }

    public Map<ItemDescription, Integer> getItemTypeCounts() {
        List<ItemDescription> types = getStoredItemTypes();
        Map<ItemDescription, Integer> counts = new HashMap<>();
        for (ItemDescription type : types) {
            counts.put(type, itemCount(type));
        }
        return counts;
    }
}
