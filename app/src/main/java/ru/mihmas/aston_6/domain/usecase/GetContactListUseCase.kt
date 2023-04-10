package ru.mihmas.aston_6.domain.usecase

import ru.mihmas.aston_6.domain.model.Contact
import ru.mihmas.aston_6.domain.repository.ContactRepository

class GetContactListUseCase(private val repository: ContactRepository) {
    fun execute(): List<Contact> = repository.getContactList()
}