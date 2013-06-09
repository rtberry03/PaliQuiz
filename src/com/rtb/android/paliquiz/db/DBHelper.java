package com.rtb.android.paliquiz.db;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;





import com.rtb.android.paliquiz.quiz.Question;


public class DBHelper extends SQLiteOpenHelper {


	private static String DATABASE_PATH = "/data/data/com.rtb.android.paliquiz/databases/";
	private static String DATABASE_NAME = "questionsDb.db";
	private final Context myContext;
	public SQLiteDatabase myDataBase;


//CHANGE THESE EVERY TIME THE DATABASE IS UPGRADED

	// Update the following, the current source file for the database

	private static String RESOURCE_FILENAME = "questionsDb8.db";
	
	// also need to update Manifest; increment versionCode & modify versionName 
	// also update strings to reflect content/availability of new chapter(s)
	// finally, update a couple of functions in SettingsActivity
	
//END CHANGE THESE

   


   /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */	

   
	public DBHelper(Context the_context) {
			super(the_context, DATABASE_NAME, null, 1);
        	this.myContext = the_context;
    	}
  
/**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{
 
    	//By calling this method and empty database will be created into the default system path
        //of your application so we are gonna be able to overwrite that database with our database.
        
	this.getReadableDatabase();

	// Log.e("@ createDataBase", "about to execute try/catch");
 
        	try {
 
    			copyDataBase();
 
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
	// Log.e("@ createDataBase", "finished");
    	
     }

    

/**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{


	// Log.e("@ copyDataBase: source = ", RESOURCE_FILENAME);
	 
    	//Open your local db as the input stream

    	InputStream myInput = myContext.getAssets().open(RESOURCE_FILENAME);
 
    	// Path to the just created empty db

    	String outFileName = DATABASE_PATH + DATABASE_NAME;
 
    	//Open the empty db as the output stream
    	
	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	
	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);

	// Log.e("@ copyDataBase", "WRITING...");
    	}
 
    	//Close the streams
 
   	myOutput.flush();
    	myOutput.close();
    	myInput.close();
	// Log.e("@ copyDataBase", "DONE!");
 
    }

  
     	public void openDataBase() throws SQLException{
 
    	//Open the database
        
	String myPath = DATABASE_PATH + DATABASE_NAME;

	// Log.e("@ openDataBase: opening = ", myPath);
    	
	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

	// Log.e("@ openDataBase", "SUCCESS");
 
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
    	    //Log.e("@ close()", "SUCCESS");
 
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
    

// Public helper method to access contents of database
	
	
	public List<Question> getQuestionSet(int chapter, int numQ){
		
		// Log.e("function List<Question>", "just entered the function");
		
		List<Question> questionSet = new ArrayList<Question>();
			
		// Log.e("function List<Question>", "made the new array");
	
		Cursor c = myDataBase.rawQuery("SELECT * FROM QUESTIONS" + chapter + " ORDER BY RANDOM() LIMIT " + numQ, null);
				
		while (c.moveToNext()){
			// Log.d("QUESTION", "Question Found in DB: " + c.getString(1));
			Question q = new Question();
			q.setQuestion(c.getString(1));
			q.setAnswer(c.getString(2));
			q.setOption1(c.getString(3));
			q.setOption2(c.getString(4));
			q.setOption3(c.getString(5));
			q.setRating(chapter);
			questionSet.add(q);
		}
		return questionSet;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}    
    
    
}   