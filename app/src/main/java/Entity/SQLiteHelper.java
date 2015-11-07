package entity;

/**
 * Created by dbakti7 on 11/2/2015.
 * This class is used to manage SQLite database
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PopularPlaceDB";
    private static final String TABLE_POPULARPLACE = "PopularPlace";
    private static final String TABLE_CURRENTPLAN = "CurrentPlan";
    private static final String TABLE_RECOMMENDEDPLAN = "RecommendedPlan";
    private static final String TABLE_STAFFPICKED = "StaffPicked";
    private static final String TABLE_OTHERPLACES = "OtherPlaces";
    private static final String TABLE_SAVEDPLANS = "SavedPlans";
    public static String strSeparator = "__,__";

    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_NAME = "name";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_DATE = "date";
    private static final String KEY_PLAN = "plan";

    private static final String[] COLUMNS = {KEY_ID, KEY_DATE, KEY_PLAN};

    /**
     * class constructor
     * @param context context
     */
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * initializing database
     * @param db database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statements to create tables
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

        String CREATE_SAVEDPLANS_TABLE = "CREATE TABLE SAVEDPLANS ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT UNIQUE, " +
                "plan TEXT )";

        // create tables
        db.execSQL(CREATE_POPULARPLACE_TABLE);
        db.execSQL(CREATE_CURRENTPLAN_TABLE);
        db.execSQL(CREATE_RECOMMENDEDPLAN_TABLE);
        db.execSQL(CREATE_STAFFPICKED_TABLE);
        db.execSQL(CREATE_OTHERPLACES_TABLE);
        db.execSQL(CREATE_SAVEDPLANS_TABLE);

        // inserting necessary information
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
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','People’s Park Complex Food Centre', 1.289898, 103.844314, 'People’s Park Complex Food Centre', 'peoples_park_complex_food_centre')");
        db.execSQL("insert into " + TABLE_RECOMMENDEDPLAN + "(category, name, latitude, longitude, description, image)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570, 'Gardens by the Bay', 'gardens_by_the_bay')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(id, category, name, latitude, longitude, description, image)" + " values(1, 'Tourist Attractions','Jurong Bird Park', 1.318803, 103.706420, 'Jurong Bird Park', 'jurong_bird_park')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Food Centres','Jurong West Block 505 Food Centre', 1.350054, 103.718148, 'Jurong West Block 505 Food Centre', 'jurong_west_block_505_food_centre')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Museums','ArtScience Museum', 1.286413, 103.859180, 'HortPark', 'hortpark')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Parks','HortPark', 1.279410, 103.797579, 'HortPark', 'hortpark')");
        db.execSQL("insert into " + TABLE_STAFFPICKED + "(category, name, latitude, longitude, description, image)" + " values('Parks','Gardens by the Bay', 1.281708, 103.863570, 'Gardens By the Bay', 'gardens_by_the_bay')");
    }


    /**
     * modifying database
     * @param db database
     * @param oldVersion old database's version
     * @param newVersion new database's version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS PopularPlace");
        db.execSQL("DROP TABLE IF EXISTS CurrentPlan");
        db.execSQL("DROP TABLE IF EXISTS RecommendedPlan");
        db.execSQL("DROP TABLE IF EXISTS StaffPicked");
        // create fresh tables
        this.onCreate(db);
    }

    /**
     * @return popular places stored in databased
     */
    public List<Location> getPopularPlaces() {
        List<Location> pplaces = new LinkedList<Location>();

        String query = "SELECT  * FROM " + TABLE_POPULARPLACE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Location pplace = null;
        if (cursor.moveToFirst()) {
            do {
                pplace = new Location();
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

    /**
     * add a new location into current plan
     * @param location location to be added into current plan
     */
    public void addLocationToCurrentPlan(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, location.getCategory());
        values.put(KEY_NAME, location.getName());
        values.put(KEY_LATITUDE, location.getLatitude());
        values.put(KEY_LONGITUDE, location.getLongitude());
        values.put(KEY_DESCRIPTION, location.getDescription());
        values.put(KEY_IMAGE, location.getImage());
        db.insert(TABLE_CURRENTPLAN, null, values);
        db.close();
    }

    /**
     *
     * @return the current plan
     */
    public List<Location> getCurrentPlan() {
        List<Location> currentPlan = new LinkedList<Location>();
        String query = "SELECT  * FROM " + TABLE_CURRENTPLAN;
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
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    /**
     * delete a location from current plan
     * @param location location to be deleted from current plan
     */
    public void deleteLocationFromCurrentPlan(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CURRENTPLAN,
                KEY_NAME + " = ?",
                new String[]{String.valueOf(location.getName())});
        db.close();
    }

    /**
     * @return the recommended plan
     */
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
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    /**
     *
     * @return the plan personally picked by the staff
     */
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
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    /**
     * add location to database if the location comes from search
     * @param location location to be added
     */
    public void addLocationToOtherPlaces(Location location) {
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

    /**
     * @return the places added from search results
     */
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
                currentPlan.add(location);
            } while (cursor.moveToNext());
        }
        return currentPlan;
    }

    /**
     * add a travel plan into calendar
     * @param currentPlan travel plan to be added
     */
    public void addPlan(Plan currentPlan) {
        String[] placeslist = currentPlan.getlocationList();
        String str = "";
        int i;
        for(i = 0;i< currentPlan.getLocationCount() - 1;++i)
            str = str + placeslist[i] + strSeparator;
        str += placeslist[i];

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, currentPlan.getDate());
        values.put(KEY_PLAN, str);

        db.insert(TABLE_SAVEDPLANS,
                null,
                values);

        db.close();
    }

    /**
     * get a plan from calendar from a specific date
     * @param dateQuery date to be queried
     * @return travel plan for that date
     */
    public String[] getPlan(String dateQuery) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =
                db.query(TABLE_SAVEDPLANS, // a. table
                        COLUMNS, // b. column names
                        " date = ?", // c. selections
                        new String[] { String.valueOf(dateQuery) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor.moveToFirst());
        else
            return null;
        String str = cursor.getString(2);
        String[] arr = str.split(strSeparator);
        return arr;
    }
}
