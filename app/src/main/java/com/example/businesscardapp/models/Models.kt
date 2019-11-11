package com.example.businesscardapp.models

import androidx.room.*
import java.util.*

object User {
    var connectionList: MutableList<Connection>? = null
    lateinit var userContact: Contact
}

@Entity(tableName = "contact_table")
class Contact(
    var name: String = "",
    var businessName: String = "",
    var businessPhone: String = "",
    var personalPhone: String = "",
    var address: String = "",
    var emailAddress: String = "",
    var businessTitle: String = "",
    var businessLogoUrl: String = "",

    @PrimaryKey()
    var id: Long = 0
)

@Entity(tableName = "connection_table")
class Connection(
    var contact: Contact,
    var date: String = "",
    var event: String = "",

    @PrimaryKey()
    var id: Long = 0
)