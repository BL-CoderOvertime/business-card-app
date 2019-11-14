package com.example.businesscardapp.localStorage

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.businesscardapp.models.Contact

class ContactRepository(application: Application) {

    private var contactDao: ContactDao

    private var allContacts: LiveData<List<Contact>>

    private var isOnline = true

    init {
        val database: UserDatabase = UserDatabase.getInstance(
            application.applicationContext
        )!!

        if (isOnline) {

            //TODO: get Data from API if valid,
            // delete local data, set local data equal to data from API
        }

        contactDao = database.contactDao()

        allContacts = contactDao.getAllContacts()
    }

    fun insert(contact: Contact) {
        val insertContactAsyncTask = InsertContactAsyncTask(contactDao).execute(contact)
    }

    fun update(contact: Contact) {
        val updateContactAsyncTask = UpdateContactAsyncTask(contactDao).execute(contact)
    }

    fun delete(contact: Contact) {
        val deleteContactAsyncTask = DeleteContactAsyncTask(contactDao).execute(contact)
    }

    fun deleteAllContacts() {
        val deleteAllContactsAsyncTask = DeleteAllContactsAsyncTask(
            contactDao
        ).execute()
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return allContacts
    }


    fun getContactsById(id:Long): LiveData<Contact> {
        return contactDao.getContactById(id)
    }

    companion object {

        private class InsertContactAsyncTask(contactDaoIn: ContactDao) :
            AsyncTask<Contact, Unit, Unit>() {
            val contactDao = contactDaoIn

            override fun doInBackground(vararg p0: Contact?) {
                contactDao.insert(p0[0]!!)
            }
        }

        private class UpdateContactAsyncTask(contactDaoIn: ContactDao) :
            AsyncTask<Contact, Unit, Unit>() {
            val contactDao = contactDaoIn

            override fun doInBackground(vararg p0: Contact?) {
                contactDao.update(p0[0]!!)
            }
        }

        private class DeleteContactAsyncTask(contactDaoIn: ContactDao) :
            AsyncTask<Contact, Unit, Unit>() {
            val contactDao = contactDaoIn

            override fun doInBackground(vararg p0: Contact?) {
                contactDao.delete(p0[0]!!)
            }
        }

        private class DeleteAllContactsAsyncTask(contactDaoIn: ContactDao) :
            AsyncTask<Unit, Unit, Unit>() {
            val contactDao = contactDaoIn

            override fun doInBackground(vararg p0: Unit?) {
                contactDao.deleteAllContacts()
            }
        }

    }

}