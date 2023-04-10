package ru.mihmas.aston_6.presentation.recyclerview_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.mihmas.aston_6.R
import ru.mihmas.aston_6.domain.model.Contact

class ContactListAdapter(
    private val context: Context
) : ListAdapter<Contact, ContactViewHolder>(ContactDiffCallback()) {
    var onContactClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.setUpValues(contact = contact, context = context)
        holder.itemView.setOnClickListener {
            onContactClickListener?.invoke(contact.id)
        }
    }

}