package ru.mihmas.aston_6.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mihmas.aston_6.data.repository.ContactRepositoryImpl
import ru.mihmas.aston_6.domain.model.Contact
import ru.mihmas.aston_6.domain.repository.ContactRepository
import ru.mihmas.aston_6.domain.usecase.DeleteContactUseCase
import ru.mihmas.aston_6.domain.usecase.GetContactListUseCase
import ru.mihmas.aston_6.domain.usecase.GetContactUseCase

class MainViewModel : ViewModel() {
    private val repository: ContactRepository = ContactRepositoryImpl
    private val getContactList = GetContactListUseCase(repository = repository)
    private val getContact = GetContactUseCase(repository = repository)
    private val deleteContact = DeleteContactUseCase(repository = repository)

    private val _contactList = MutableLiveData<List<Contact>>()
    val contactList: LiveData<List<Contact>> = _contactList

    fun getContactList() {
        _contactList.value = getContactList.execute()
    }

    fun getContact(contactId: Int): Contact = getContact.execute(contactId = contactId)
    fun deleteContact(contactId: Int) = deleteContact.execute(contactId = contactId)
}