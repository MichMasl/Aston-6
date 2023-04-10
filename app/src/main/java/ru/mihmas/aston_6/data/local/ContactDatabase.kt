package ru.mihmas.aston_6.data.local

import com.github.javafaker.Faker
import ru.mihmas.aston_6.domain.model.Contact
import kotlin.random.Random

class ContactDatabase {
    private val faker = Faker()
    val contactList = mutableListOf<Contact>()

    init {
        for (i in 0..149) {
            contactList.add(
                Contact(
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    phoneNumber = phoneNumberCorrecter(faker.phoneNumber().subscriberNumber(10)),
                    image = "https://picsum.photos/id/${Random.nextInt(0,149)}/90/90",
                    id = i
                )
            )
        }
    }

    private fun phoneNumberCorrecter(number: String): String = "+$number"
}