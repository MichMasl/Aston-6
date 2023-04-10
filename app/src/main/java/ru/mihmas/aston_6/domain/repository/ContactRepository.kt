package ru.mihmas.aston_6.domain.repository

import ru.mihmas.aston_6.domain.model.Contact

interface ContactRepository {
    fun getContactList(): List<Contact>
    fun getContact(contactId: Int): Contact
    fun deleteContact(contactId: Int)
}