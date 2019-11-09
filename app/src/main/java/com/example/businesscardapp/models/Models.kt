package com.example.businesscardapp.models

import java.util.*

class User(
    var connectionList: MutableList<Connection>? = null,
    var userCardHolder: CardHolder
)
class CardHolder(
    var name: String = "",
    var businessName: String = "",
    var businessPhone: String = "",
    var personalPhone: String = "",
    var address: String = "",
    var emailAddress: String = "",
    var businessTitle: String = "",
    var businessLogoUrl: String = ""
)

class Connection(var contact: CardHolder, var date: String = "", var event: String = "")