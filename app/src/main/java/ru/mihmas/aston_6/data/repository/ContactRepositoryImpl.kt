package ru.mihmas.aston_6.data.repository

import ru.mihmas.aston_6.data.local.ContactDatabase
import ru.mihmas.aston_6.domain.model.Contact
import ru.mihmas.aston_6.domain.repository.ContactRepository

object ContactRepositoryImpl : ContactRepository {
    private val local = ContactDatabase()
    override fun getContactList(): List<Contact> = local.contactList
    override fun getContact(contactId: Int): Contact = local.contactList[contactId]
    override fun deleteContact(contactId: Int) {
        local.contactList.removeAt(contactId)
    }

}