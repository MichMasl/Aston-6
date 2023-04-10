package ru.mihmas.aston_6.presentation.recyclerview_adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mihmas.aston_6.R
import ru.mihmas.aston_6.domain.model.Contact

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val firstName: TextView = view.findViewById(R.id.first_name)
    private val lastName: TextView = view.findViewById(R.id.last_name)
    private val phoneNumber: TextView = view.findViewById(R.id.phone_number)
    private val id: TextView = view.findViewById(R.id.id_value)
    private val image: ImageView = view.findViewById(R.id.image_view)

    fun setUpValues(contact: Contact, context: Context) {
        firstName.text = contact.firstName
        lastName.text = contact.lastName
        phoneNumber.text = contact.phoneNumber
        id.text = contact.id.toString()
        Glide.with(context).load(contact.image).placeholder(R.drawable.placeholder).into(image)
    }
}