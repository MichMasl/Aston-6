package ru.mihmas.aston_6.domain.usecase

import ru.mihmas.aston_6.domain.repository.ContactRepository

class DeleteContactUseCase(private val repository: ContactRepository) {
    fun execute(contactId: Int) = repository.deleteContact(contactId = contactId)
}