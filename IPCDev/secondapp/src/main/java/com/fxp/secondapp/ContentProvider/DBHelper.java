package com.fxp.secondapp.ContentProvider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Title:       DBHelper
 * <p>
 * Package:     com.fxp.secondapp.ContentProvider
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/9 10:51 PM
 * <p>
 * Description: ContentProvider跨进程通信demo
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/1/9    fxp       1.0         First Created
 * <p>
 * Copyright:   Copyright (c)2019    www.szxhdz.com Inc. All rights reserved.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "userInfo.db";

    private static final int DB_VERSION = 1;

    public static final String TABLE_USER_INFO = "userInfo";

    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_AGE = "user_age";

    private static final String USERINFO_TABLE_SQL = "CREATE TABLE " + TABLE_USER_INFO + "(" + USER_ID + " TEXT ," + USER_NAME + " TEXT," + USER_AGE + " TEXT" + ")";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    /**
     * 1、在第一次打开数据库的时候才会走
     * 2、在清除数据之后再次运行-->打开数据库，这个方法会走
     * 3、没有清除数据，不会走这个方法
     * 4、数据库升级的时候这个方法不会走
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USERINFO_TABLE_SQL);
    }

    /**
     * 1、第一次创建数据库的时候，这个方法不会走
     * 2、清除数据后再次运行(相当于第一次创建)这个方法不会走
     * 3、数据库已经存在，而且版本升高的时候，这个方法才会调用
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
