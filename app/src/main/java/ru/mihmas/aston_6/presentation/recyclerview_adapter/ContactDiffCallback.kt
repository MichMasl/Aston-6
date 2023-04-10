package ru.mihmas.aston_6.presentation.recyclerview_adapter

import androidx.recyclerview.widget.DiffUtil
import ru.mihmas.aston_6.domain.model.Contact

class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}