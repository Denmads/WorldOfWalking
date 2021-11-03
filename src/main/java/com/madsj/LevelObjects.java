package com.madsj;

public class LevelObjects {

    private LevelObjects() {}

    private static ItemDictionary itemDB = new ItemDictionary();
    private static StorageDictionary storageDB = new StorageDictionary();

    public static ItemDictionary getItemDB() {
        return itemDB;
    }

    public static StorageDictionary getStorageDB() {
        return storageDB;
    }
}
