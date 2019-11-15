package com.example.businesscardapp.localStorage

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.businesscardapp.models.Contact

@Database(entities = [Contact::class], exportSchema = true, version = 4)
abstract class UserDatabase : RoomDatabase() {

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

        override fun doInBackground(vararg p0: Unit?) {
            contactDao?.insert(Contact("Lauraine","Fairburn","Zava","158-853-9286","508-224-1440","0395 Kennedy Street","lfairburn0@jimdo.com","Desktop Support Technician","http://dummyimage.com/132x178.png/5fa2dd/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Gawain","Lage","Youspan","922-672-5228","680-137-4885","5 Northwestern Way","glage1@ycombinator.com","Design Engineer","http://dummyimage.com/243x145.png/5fa2dd/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Clementine","Slinger","Quire","341-669-0731","275-314-5758","569 Oak Parkway","cslinger2@soup.io","Desktop Support Technician","http://dummyimage.com/163x172.jpg/dddddd/000000", 0, "", ""))
            contactDao?.insert(Contact("Phelia","Garwell","Quinu","111-207-0044","130-553-7069","22936 Division Crossing","pgarwell3@bravesites.com","Compensation Analyst","http://dummyimage.com/182x243.bmp/dddddd/000000", 0, "", ""))
            contactDao?.insert(Contact("Farr","Brandreth","Thoughtsphere","818-447-2770","369-787-7694","51642 Havey Plaza","fbrandreth4@ucsd.edu","Analog Circuit Design manager","http://dummyimage.com/226x178.bmp/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Phip","Legion","Kaymbo","573-783-3909","390-505-6048","191 Glendale Parkway","plegion5@cam.ac.uk","Mechanical Systems Engineer","http://dummyimage.com/145x225.bmp/5fa2dd/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Wandie","Knappitt","Ainyx","383-175-1736","112-387-5005","0293 Butternut Way","wknappitt6@cbsnews.com","Office Assistant II","http://dummyimage.com/205x224.bmp/cc0000/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Zuzana","Beernt","Voolith","571-174-8910","659-815-3000","94 Anderson Drive","zbeernt7@cisco.com","Tax Accountant","http://dummyimage.com/146x249.bmp/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Gunar","Lismer","Devify","214-119-8462","988-901-3480","54 La Follette Street","glismer8@springer.com","Technical Writer","http://dummyimage.com/149x173.png/cc0000/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Des","Gurery","Thoughtsphere","902-823-1464","239-632-3660","8711 Meadow Valley Place","dgurery9@rakuten.co.jp","Food Chemist","http://dummyimage.com/214x111.bmp/5fa2dd/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Gabbi","Dykins","Jamia","462-818-0267","971-949-6394","61423 Magdeline Trail","gdykinsa@is.gd","Legal Assistant","http://dummyimage.com/145x232.jpg/5fa2dd/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Burnaby","Edington","Yakitri","332-323-0086","794-307-8443","9 Shelley Parkway","bedingtonb@home.pl","Quality Control Specialist","http://dummyimage.com/210x107.jpg/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Patrick","Bigley","Photofeed","964-778-9449","985-277-6674","2 Mendota Hill","pbigleyc@usnews.com","Tax Accountant","http://dummyimage.com/230x123.jpg/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Tom","Sommer","Topdrive","104-264-2431","979-410-3336","1 Hoffman Point","tsommerd@archive.org","Systems Administrator III","http://dummyimage.com/119x234.png/cc0000/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Jeramey","Polly","Lazzy","569-705-4652","200-731-6681","767 Merry Lane","jpollye@ehow.com","Analog Circuit Design manager","http://dummyimage.com/195x119.bmp/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Zola","Betjeman","Skinte","692-792-5746","859-379-1300","4226 Linden Trail","zbetjemanf@harvard.edu","Help Desk Operator","http://dummyimage.com/181x145.bmp/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Ike","Cicculini","Livepath","728-793-3960","849-519-0880","73 Twin Pines Center","icicculinig@shutterfly.com","Legal Assistant","http://dummyimage.com/125x122.jpg/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Deeyn","McGiffie","Roodel","886-432-5715","753-874-8711","85529 Elmside Terrace","dmcgiffieh@ted.com","Analog Circuit Design manager","http://dummyimage.com/146x103.png/ff4444/ffffff", 0, "", ""))
            contactDao?.insert(Contact("Fiorenze","Bocock","Vitz","570-827-7445","683-806-5439","59 Carberry Point","fbococki@t-online.de","Safety Technician I","http://dummyimage.com/116x202.png/dddddd/000000", 0, "", ""))
            contactDao?.insert(Contact("Valentino","Linskey","Blognation","715-247-5228","178-660-3127","4 Veith Alley","vlinskeyj@sciencedirect.com","Marketing Assistant","http://dummyimage.com/217x180.png/5fa2dd/ffffff", 0, "", ""))
        }
    }
}