package ru.mihmas.aston_6.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.mihmas.aston_6.R
import ru.mihmas.aston_6.presentation.viewmodel.MainViewModel

class ContactDetailFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }

    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var image: ImageView
    private lateinit var id: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contactId = requireArguments().getInt(CONTACT_ID)
        setupViews(view)
        setupContactFieldValues(contactId)
    }

    private fun setupViews(view: View) {
        firstName = view.findViewById(R.id.first_name)
        lastName = view.findViewById(R.id.last_name)
        phoneNumber = view.findViewById(R.id.phone_number)
        image = view.findViewById(R.id.image_view)
        id = view.findViewById(R.id.id_value)
    }

    private fun setupContactFieldValues(contactId: Int) {
        firstName.text = viewModel.getContact(contactId = contactId).firstName
        lastName.text = viewModel.getContact(contactId = contactId).lastName
        phoneNumber.text = viewModel.getContact(contactId = contactId).phoneNumber
        id.text = viewModel.getContact(contactId = contactId).id.toString()
        Glide.with(requireContext())
            .load(viewModel.getContact(contactId).image)
            .placeholder(R.drawable.placeholder)
            .into(image)
    }

    companion object {
        private const val CONTACT_ID = "contact id"
        fun newInstance(contactId: Int): ContactDetailFragment = ContactDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(CONTACT_ID, contactId)
            }
        }
    }
}