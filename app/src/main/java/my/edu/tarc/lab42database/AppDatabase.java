package my.edu.tarc.lab42database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;


//TODO 5: Create a database class

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //Create an instance of the Room Database
    private static volatile AppDatabase INSTANCE;

    //Create an instance of the DAO
    public abstract UserDao userDao();
    private LiveData<List<User>> allUser;

    static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    //Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "user_db")
                    .build();
                }
            }
        }
        return INSTANCE;
    }

}
