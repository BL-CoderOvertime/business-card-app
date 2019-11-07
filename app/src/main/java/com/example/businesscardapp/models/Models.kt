package com.example.businesscardapp.models

class User(
    var contactList: MutableList<CardHolder>? = null,
    var userCardHolder: CardHolder
) {}

class CardHolder(
    var name: String = "",
    var businessName: String = "",
    var businessPhone: String = "",
    var personalPhone: String = "",
    var address: String = "",
    var emailAddress: String = "",
    var businessTitle: String = "",
    var businessLogoUrl: String = ""
) {}