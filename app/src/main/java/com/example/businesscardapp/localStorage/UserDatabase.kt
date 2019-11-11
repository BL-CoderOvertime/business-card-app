package com.example.businesscardapp.localStorage

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.businesscardapp.models.Connection
import com.example.businesscardapp.models.Contact

@Database(entities = [Connection::class, Contact::class], exportSchema = true, version = 30)
abstract class UserDatabase : RoomDatabase() {

    abstract fun connectionDao(): ConnectionDao
    abstract fun contactDao(): ContactDao

    companion object {
        private var instance: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java, "user_database"
                    )
                        .fallbackToDestructiveMigration() // when version increments, it migrates (deletes db and creates new) - else it crashes
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }

    //Mock Data here
    class PopulateDbAsyncTask(db: UserDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val contactDao = db?.contactDao()
        private val connectionDao = db?.connectionDao()

        override fun doInBackground(vararg p0: Unit?) {
//setup mock data here
        }
    }
}