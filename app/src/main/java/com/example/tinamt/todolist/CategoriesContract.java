package com.example.tinamt.todolist;

import android.provider.BaseColumns;

public final class CategoriesContract {
    public CategoriesContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "categories";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_CATEGORY_NAME = "categoryName";
    }
}
