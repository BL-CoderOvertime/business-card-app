package com.wkdrabbit.vacationtimeline.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.businesscardapp.localStorage.ContactRepository
import com.example.businesscardapp.models.Contact

class ContactViewModel(application: Application) : AndroidViewModel(application){
    private var repository: ContactRepository =
        ContactRepository(application)
    private var allContacts: LiveData<List<Contact>> = repository.getAllContacts()

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun update(contact: Contact) {
        repository.update(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }

    fun deleteAllContacts() {
        repository.deleteAllContacts()
    }

    fun getAllContact(): LiveData<List<Contact>> {
        return allContacts
    }

    fun getContactById(id:Long):LiveData<Contact>{
        return repository.getContactsById(id)
    }
}