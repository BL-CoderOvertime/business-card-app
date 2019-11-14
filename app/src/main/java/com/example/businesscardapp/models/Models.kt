package com.example.businesscardapp.models

import androidx.room.*

object User {
    var contactList = mutableListOf<Contact>()
    lateinit var userContact: Contact
}

@Entity(tableName = "contact_table")
class Contact(
    var firstName: String = "",
    var lastName: String = "",
    var businessName: String = "",
    var businessPhone: String = "",
    var personalPhone: String = "",
    var address: String = "",
    var emailAddress: String = "",
    var businessTitle: String = "",
    var businessLogoUrl: String = "",
    var connection_id: Long,
    var date: String = "",
    var event: String = "",

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)
