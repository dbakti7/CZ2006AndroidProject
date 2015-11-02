package entity;

/**
 * Created by dbakti7 on 11/2/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "PopularPlaceDB";

    // Books table name
    private static final String TABLE_POPULARPLACE = "PopularPlace";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_NAME = "name";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";

    private static final String[] COLUMNS = {KEY_ID, KEY_CATEGORY, KEY_NAME, KEY_LATITUDE, KEY_LONGITUDE};


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_POPULARPLACE_TABLE = "CREATE TABLE PopularPlace ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT, "+
                "latitude REAL, " +
                "longitude REAL )";

        String CREATE_CURRENTPLAN_TABLE = "CREATE TABLE CURRENTPLAN ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT, "+
                "latitude REAL, " +
                "longitude REAL )";
        // create books table
        db.execSQL(CREATE_POPULARPLACE_TABLE);

        db.execSQL("insert into " + TABLE_POPULARPLACE + "(id, category, name, latitude, longitude)" + " values(1, 'Tourist Attractions','Merlion', 2.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Tourist Attractions','Merlion2', 22.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Hotel 1', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Hotel 2', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','FC 1', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','FC 2', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','Park 1', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','Park 2', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','Museum 1', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','Museum 2', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Library 1', 3.0, 2.0)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Library 2', 3.0, 2.0)");
        //db.execSQL("insert into " + TABLE_POPULARPLACE + " values(value1,value2...);");
        //db.execSQL("insert into " + TABLE_POPULARPLACE + " values(value1,value2...);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS PopularPlace");

        // create fresh books table
        this.onCreate(db);
    }

    public void addPopularPlace(PopularPlace PopularPlace){
        //for logging
        //Log.d("addBook", book.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, PopularPlace.getCategory()); // get title
        values.put(KEY_NAME, PopularPlace.getName());
        values.put(KEY_LATITUDE, PopularPlace.getLatitude());
        values.put(KEY_LONGITUDE, PopularPlace.getLongitude());

        // 3. insert
        db.insert(TABLE_POPULARPLACE, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public PopularPlace getPopularPlace(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_POPULARPLACE, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        PopularPlace pplace = new PopularPlace();
        pplace.setId(Integer.parseInt(cursor.getString(0)));
        pplace.setCategory(cursor.getString(1));
        pplace.setName(cursor.getString(2));
        pplace.setLatitude(Double.parseDouble(cursor.getString(3)));
        pplace.setLongitude(Double.parseDouble(cursor.getString(4)));


        //log
        //Log.d("getBook(" + id + ")", book.toString());

        // 5. return book
        return pplace;
    }

    public List<PopularPlace> getPopularPlaces() {
        List<PopularPlace> pplaces = new LinkedList<PopularPlace>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_POPULARPLACE;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        PopularPlace pplace = null;
        if (cursor.moveToFirst()) {
            do {
                pplace = new PopularPlace();
                pplace.setId(Integer.parseInt(cursor.getString(0)));
                pplace.setCategory(cursor.getString(1));
                pplace.setName(cursor.getString(2));
                pplace.setLatitude(Double.parseDouble(cursor.getString(3)));
                pplace.setLongitude(Double.parseDouble(cursor.getString(4)));

                // Add book to books
                pplaces.add(pplace);
            } while (cursor.moveToNext());
        }

        //Log.d("getAllBooks()", books.toString());

        return pplaces;
    }

    public int updatePopularPlace(PopularPlace pplace) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("category", pplace.getCategory());
        values.put("name", pplace.getName());
        values.put("latitude", pplace.getLatitude());
        values.put("longitude", pplace.getLongitude());

        // 3. updating row
        int i = db.update(TABLE_POPULARPLACE, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(pplace.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public void deleteBook(PopularPlace pplace) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_POPULARPLACE, //table name
                KEY_ID + " = ?",  // selections
                new String[]{String.valueOf(pplace.getId())}); //selections args

        // 3. close
        db.close();

        //log
        //Log.d("deleteBook", pplace.toString());

    }
}
