package com.example.businesscardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.businesscardapp.models.Contact
import com.example.businesscardapp.viewmodels.ContactViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    private lateinit var contactList: List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

        contactViewModel.getAllContact().observe(this, Observer<List<Contact>> {
            contactList = it.toList()
        })

    }
}
