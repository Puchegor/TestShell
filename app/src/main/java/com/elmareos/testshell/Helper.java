package com.elmareos.testshell;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Helper extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private static String DB_NAME ="ectheory.db";
    private SQLiteDatabase db;
    private Context mContext;;

    public Helper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        copyDataBase();
    }

    private void copyDataBase (){
        if (!checkDatabase()){
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            }catch (IOException e){
                Toast.makeText(mContext, "какая-то фигня с базой данных"+e.getLocalizedMessage(), Toast.LENGTH_LONG);
            }
        }
    }

    private boolean checkDatabase(){
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDBFile () throws IOException{
        InputStream input = mContext.getAssets().open(DB_NAME);
        OutputStream output = new FileOutputStream(DB_PATH + DB_NAME);
        byte [] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0 )
            output.write(buffer, 0, length);
        output.flush();
        output.close();
        input.close();
    }

    public boolean openDatabase () throws SQLException{
        db = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return db != null;
    }

    @Override
    public synchronized void close(){
        if (db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
