package ru.mihmas.aston_6.domain.usecase

import ru.mihmas.aston_6.domain.model.Contact
import ru.mihmas.aston_6.domain.repository.ContactRepository

class GetContactUseCase(private val repository: ContactRepository) {
    fun execute(contactId: Int): Contact = repository.getContact(contactId = contactId)
}