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
    private static final String TABLE_RECOMMENDEDPLAN = "RecommendedPlan";
    private static final String TABLE_STAFFPICKED = "StaffPicked";
    private static final String TABLE_OTHERPLACES = "OtherPlaces";

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
                "name TEXT UNIQUE, "+
                "latitude REAL, " +
                "longitude REAL, " +
                "description TEXT, " +
                "image TEXT )";

        String CREATE_CURRENTPLAN_TABLE = "CREATE TABLE CURRENTPLAN ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT UNIQUE, "+
                "latitude REAL, " +
                "longitude REAL, " +
                "description TEXT, " +
                "image TEXT )";

        String CREATE_RECOMMENDEDPLAN_TABLE = "CREATE TABLE RECOMMENDEDPLAN ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT UNIQUE, "+
                "latitude REAL, " +
                "longitude REAL, " +
                "description TEXT, " +
                "image TEXT )";

        String CREATE_STAFFPICKED_TABLE = "CREATE TABLE STAFFPICKED ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT UNIQUE, "+
                "latitude REAL, " +
                "longitude REAL, " +
                "description TEXT, " +
                "image TEXT )";

        String CREATE_OTHERPLACES_TABLE = "CREATE TABLE OTHERPLACES ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT, " +
                "name TEXT UNIQUE, "+
                "latitude REAL, " +
                "longitude REAL, " +
                "description TEXT, " +
                "image TEXT )";
        // create books table
        db.execSQL(CREATE_POPULARPLACE_TABLE);
        db.execSQL(CREATE_CURRENTPLAN_TABLE);
        db.execSQL(CREATE_RECOMMENDEDPLAN_TABLE);
        db.execSQL(CREATE_STAFFPICKED_TABLE);
        db.execSQL(CREATE_OTHERPLACES_TABLE);


        db.execSQL("insert into " + TABLE_POPULARPLACE + "(id, category, name, latitude, longitude, description, image)" + " values(1, 'Tourist Attractions','Singapore Flyer', 1.289572, 103.863121,'Singapore Flyer', 'singapore_flyer')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Tourist Attractions','Jurong Bird Park', 1.318803, 103.706420,'Jurong Bird Park','jurong_bird_park')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Tourist Attractions','Singapore Zoo', 1.404627, 103.793023,'Singapore Zoo','singapore_zoo')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Tourist Attractions','Universal Studios Singapore', 1.254278, 103.823765,'Universal Studios Singapore','universal_studios_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Tourist Attractions','Night Safari', 1.402198, 103.788125,'Night Safari','night_safari')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Museums','ArtScience Museum', 1.286413, 103.859180,'ArtScience Museum','artScience_museum')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Museums','National Museum of Singapore', 1.296857, 103.848527,'National Museum of Singapore','national_museum_of_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Museums','National Design Centre', 1.298873, 103.853569,'National Design Centre','national_design_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Museums','National Gallery Singapore', 1.290518, 103.851630,'National Gallery Singapore','national_gallery_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Museums','Asian Civilisations Museum', 1.287760, 103.851433,'Asian Civilisations Museum','asian_civilisations_museum')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Jurong West Block 505 Food Centre', 1.350054, 103.718148,'Jurong West Block 505 Food Centre','jurong_west_block_505_food_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','People’s Park Complex Food Centre', 1.289898, 103.844314,'People’s Park Complex Food Centre','peoples_park_complex_food_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Ayer Rajah Food Centre', 1.312293, 103.760243,'Ayer Rajah Food Centre','ayer_rajah_food_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Zion Riverside Food Centre', 1.292843, 103.831231,'Zion Riverside Food Centre','zion_riverside_food_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Toa Payoh Lorong 8 Hawker Centre',1.342622, 103.854462,'Toa Payoh Lorong 8 Hawker Centre','toa_payoh_lorong_8_hawker_centre')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Hotels','Shangri-La Hotel', 1.311685, 103.826138,'Shangri-La Hotel','shangri-la_hotel')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Hotels','Singapore Marriott Hotel', 1.305624, 103.832580,'Singapore Marriott Hotel','singapore_marriott_hotel')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Hotels','Furama Riverfront Singapore',1.288143, 103.836001,'Furama Riverfront Singapore','furama_riverfront_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Hotels','Concorde Hotel Singapore',1.300804, 103.842154,'Concorde Hotel Singapore','concorde_hotel_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Hotels','The Fullerton Singapore', 1.286557, 103.853046,'The Fullerton Singapore','the_fullerton_singapore')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Parks','Chinese Garden', 1.338718, 103.730064,'Chinese Garden','chinese_garden')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Parks','East Coast Park', 1.300891, 103.912079,'East Coast Park','east_coast_park')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Parks','HortPark', 1.279410, 103.797579,'HortPark','hortpark')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Parks','FortCanning Park', 1.295693, 103.847447,'FortCanning Park','fortcanning_park')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570,'Gardens by the Bay','gardens_by_the_bay')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','Bishan Public Library', 1.355557, 103.849018,'Bishan Public Library','bishan_public_library')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','Toa Payoh public library',1.333859, 103.850504,'Toa Payoh public library','toa_payoh_public_library')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','National Library, Singapore', 1.297910, 103.854287,'National Library, Singapore','national_library_singapore' )");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','Library @Esplanade',1.289775, 103.856103,'Library @Esplanade','library_esplanade')");
        db.execSQL("insert into " + TABLE_POPULARPLACE + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','Queenstown Library', 1.298951, 103.805379,'Queenstown Library','queenstown_library')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(id, category, name, latitude, longitude, description, image)" + " values(1, 'Museums','National Gallery Singapore', 1.290518, 103.851630, 'National Gallery Singapore', 'national_gallery_singapore')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Museums','National Design Centre', 1.298873, 103.853569, 'National Design Centre', 'national_design_centre')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Public Libraries','National Library, Singapore', 1.297910, 103.854287, 'National Library, Singapore', 'national_library_singapore')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Peoples Park Complex Food Centre', 1.289898, 103.844314, 'People’s Park Complex Food Centre', 'peoples_park_complex_food_centre')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570, 'Gardens by the Bay', 'gardens_by_the_bay')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(id, category, name, latitude, longitude, description, image)" + " values(1, 'Tourist Attractions','Jurong Bird Park', 1.318803, 103.706420, 'Jurong Bird Park', 'jurong_bird_park')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Jurong West Block 505 Food Centre', 1.350054, 103.718148, 'Jurong West Block 505 Food Centre', 'jurong_west_block_505_food_centre')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Museums','ArtScience Museum', 1.286413, 103.859180, 'HortPark', 'hortpark')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Parks','HortPark', 1.279410, 103.797579, 'HortPark', 'hortpark')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570, 'Gardens By the Bay', 'gardens_by_the_bay')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS PopularPlace");
        db.execSQL("DROP TABLE IF EXISTS CurrentPlan");
        db.execSQL("DROP TABLE IF EXISTS RecommendedPlan");
        db.execSQL("DROP TABLE IF EXISTS StaffPicked");
        // create fresh books table
        this.onCreate(db);
    }

    public void addPopularPlace(Location location){
        //for logging
        //Log.d("addBook", book.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, location.getCategory()); // get title
        values.put(KEY_NAME, location.getName());
        values.put(KEY_LATITUDE, location.getLatitude());
        values.put(KEY_LONGITUDE, location.getLongitude());
        values.put(KEY_DESCRIPTION, location.getDescription());
        values.put(KEY_IMAGE, location.getImage());

        // 3. insert
        db.insert(TABLE_POPULARPLACE, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Location getPopularPlace(int id){

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

        Location pplace = new Location();
        //pplace.setId(Integer.parseInt(cursor.getString(0)));
        pplace.setCategory(cursor.getString(1));
        pplace.setName(cursor.getString(2));
        pplace.setPos(cursor.getDouble(3), cursor.getDouble(4));
        pplace.setDescription(cursor.getString(5));
        pplace.setImage(cursor.getString(6));
        return pplace;
    }

    public List<Location> getPopularPlaces() {
        List<Location> pplaces = new LinkedList<Location>();

        String query = "SELECT  * FROM " + TABLE_POPULARPLACE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Location pplace = null;
        if (cursor.moveToFirst()) {
            do {
                pplace = new Location();
                //pplace.setId(Integer.parseInt(cursor.getString(0)));
                pplace.setCategory(cursor.getString(1));
                pplace.setName(cursor.getString(2));
                pplace.setPos(cursor.getDouble(3), cursor.getDouble(4));
                pplace.setDescription(cursor.getString(5));
                pplace.setImage(cursor.getString(6));

                pplaces.add(pplace);
            } while (cursor.moveToNext());
        }
        return pplaces;
    }

    public int updatePopularPlace(Location pplace) {

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
                KEY_NAME+" = ?", // selections
                new String[] { String.valueOf(pplace.getName()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public void deletePopularPlace(Location pplace) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_POPULARPLACE, //table name
                KEY_NAME + " = ?",  // selections
                new String[]{String.valueOf(pplace.getName())}); //selections args

        // 3. close
        db.close();

        //log
        //Log.d("deleteBook", pplace.toString());

    }

    public void addLocationtoCurrentPlan(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, location.getCategory());
        values.put(KEY_NAME, location.getName()); // get title
        values.put(KEY_LATITUDE, location.getLatitude());
        values.put(KEY_LONGITUDE, location.getLongitude());
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
                location.setCategory(cursor.getString(1));
                location.setName(cursor.getString(2));
                location.setPos(cursor.getDouble(3), cursor.getDouble(4));
                location.setDescription(cursor.getString(5));
                location.setImage(cursor.getString(6));

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

    public List<Location> getRecommendedPlan() {
        List<Location> currentPlan = new LinkedList<Location>();


        String query = "SELECT  * FROM " + TABLE_RECOMMENDEDPLAN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Location location = null;
        if (cursor.moveToFirst()) {
            do {
                location = new Location();
                location.setCategory(cursor.getString(1));
                location.setName(cursor.getString(2));
                location.setPos(cursor.getDouble(3), cursor.getDouble(4));
                location.setDescription(cursor.getString(5));
                location.setImage(cursor.getString(6));

                // Add book to books
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    public List<Location> getStaffPicked() {
        List<Location> currentPlan = new LinkedList<Location>();
        String query = "SELECT  * FROM " + TABLE_STAFFPICKED;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Location location = null;
        if (cursor.moveToFirst()) {
            do {
                location = new Location();
                location.setCategory(cursor.getString(1));
                location.setName(cursor.getString(2));
                location.setPos(cursor.getDouble(3), cursor.getDouble(4));
                location.setDescription(cursor.getString(5));
                location.setImage(cursor.getString(6));

                // Add book to books
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    public void addLocationtoOtherPlaces(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, location.getCategory());
        values.put(KEY_NAME, location.getName());
        values.put(KEY_LATITUDE, location.getLatitude());
        values.put(KEY_LONGITUDE, location.getLongitude());
        values.put(KEY_DESCRIPTION, location.getDescription());
        values.put(KEY_IMAGE, location.getImage());

        db.insert(TABLE_OTHERPLACES,
                null,
                values);

        db.close();
    }

    public List<Location> getOtherPlaces() {
        List<Location> currentPlan = new LinkedList<Location>();
        String query = "SELECT  * FROM " + TABLE_OTHERPLACES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Location location = null;
        if (cursor.moveToFirst()) {
            do {
                location = new Location();
                location.setCategory(cursor.getString(1));
                location.setName(cursor.getString(2));
                location.setPos(cursor.getDouble(3), cursor.getDouble(4));
                location.setDescription(cursor.getString(5));
                location.setImage(cursor.getString(6));

                // Add book to books
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }
}
