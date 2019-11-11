package com.example.businesscardapp.localStorage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.businesscardapp.models.Connection
import com.example.businesscardapp.models.Contact

@Dao
interface ConnectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(connection: Connection)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(connection:Connection)

    @Delete
    fun delete(connection: Connection)

    @Query("DELETE FROM connection_table")
    fun deleteAllConnections()

    @Query("SELECT * FROM connection_table")
    fun getAllConnections(): LiveData<List<Connection>>

    @Query("SELECT * FROM connection_table WHERE id IS :id")
    fun getConnectionById(id: Long): LiveData<Connection>
}