package com.example.businesscardapp.localStorage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.businesscardapp.models.Contact

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(contact:Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("DELETE FROM contact_table")
    fun deleteAllContacts()

    @Query("SELECT * FROM contact_table")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contact_table WHERE id IS :id")
    fun getContactById(id: Long): LiveData<Contact>
}