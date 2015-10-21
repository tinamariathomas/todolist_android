package com.example.tinamt.todolist;

import android.provider.BaseColumns;

public final class CategoriesContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public CategoriesContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class CatgoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "categories";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_CATEGORY_NAME = "categoryName";
    }
}
