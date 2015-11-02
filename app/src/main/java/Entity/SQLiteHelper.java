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
    private static final String TABLE_CURRENTPLAN = "CurrentPlan";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_NAME = "name";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";

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
                "name TEXT, " +
                "category TEXT, "+
                "description TEXT, " +
                "image TEXT )";
        // create books table
        db.execSQL(CREATE_POPULARPLACE_TABLE);
        db.execSQL(CREATE_CURRENTPLAN_TABLE);

        db.execSQL("insert into " + TABLE_POPULARPLACE + "(id, category, name, latitude, longitude)" + " values(1, 'Tourist Attractions','Singapore Flyer', 1.289572, 103.863121)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Tourist Attractions','Jurong Bird Park', 1.318803, 103.706420)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Tourist Attractions','Singapore Zoo', 1.404627, 103.793023)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Tourist Attractions','Universal Studios Singapore', 1.254278, 103.823765)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Tourist Attractions','Night Safari', 1.402198, 103.788125)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','ArtScience Museum', 1.286413, 103.859180)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','National Museum of Singapore', 1.296857, 103.848527)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','National Design Centre', 1.298873, 103.853569)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','National Gallery Singapore', 1.290518, 103.851630)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Museums','Asian Civilisations Museum', 1.287760, 103.851433)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','Jurong West Block 505 Food Centre', 1.350054, 103.718148)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','People’s Park Complex Food Centre', 1.289898, 103.844314)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','Ayer Rajah Food Centre', 1.312293, 103.760243)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','Zion Riverside Food Centre', 1.292843, 103.831231)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Food Centres','Toa Payoh Lorong 8 Hawker Centre',1.342622, 103.854462)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Shangri-La Hotel', 1.311685, 103.826138)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Singapore Marriott Hotel', 1.305624, 103.832580)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Furama Riverfront Singapore',1.288143, 103.836001)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','Concorde Hotel Singapore',1.300804, 103.842154)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Hotels','The Fullerton Singapore', 1.286557, 103.853046)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','Chinese Garden', 1.338718, 103.730064)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','East Coast Park', 1.300891, 103.912079)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','HortPark', 1.279410, 103.797579)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','FortCanning Park', 1.295693, 103.847447)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Bishan Public Library', 1.355557, 103.849018)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Toa Payoh public library',1.333859, 103.850504)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','National Library, Singapore', 1.297910, 103.854287 )");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Library @Esplanade',1.289775, 103.856103)");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude)" + " values('Public Libraries','Queenstown Library', 1.298951, 103.805379)");
        //db.execSQL("insert into " + TABLE_POPULARPLACE + " values(value1,value2...);");
        //db.execSQL("insert into " + TABLE_POPULARPLACE + " values(value1,value2...);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS PopularPlace");
        db.execSQL("DROP TABLE IF EXISTS CurrentPlan");
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

    public void addLocationtoCurrentPlan(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, location.getName()); // get title
        values.put(KEY_CATEGORY, location.getCategory());
        values.put(KEY_DESCRIPTION, location.getDescription());
        values.put(KEY_IMAGE, location.getImage());

        // 3. insert
        db.insert(TABLE_CURRENTPLAN, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public List<Location> getCurrentPlan() {
        List<Location> currentPlan = new LinkedList<Location>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_CURRENTPLAN;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Location location = null;
        if (cursor.moveToFirst()) {
            do {
                location = new Location();
                location.setName(cursor.getString(1));
                location.setCategory(cursor.getString(2));
                location.setDescription(cursor.getString(3));
                location.setImage(cursor.getString(4));

                // Add book to books
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }

        //Log.d("getAllBooks()", books.toString());

        return currentPlan;
    }

    public void deleteLocation(Location location) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_CURRENTPLAN, //table name
                KEY_NAME + " = ?",  // selections
                new String[]{String.valueOf(location.getName())}); //selections args

        // 3. close
        db.close();
    }
}
