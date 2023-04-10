package ru.mihmas.aston_6.domain.model

data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val image: String,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
