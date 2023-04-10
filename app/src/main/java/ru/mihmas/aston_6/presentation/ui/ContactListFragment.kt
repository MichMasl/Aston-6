package ru.mihmas.aston_6.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.mihmas.aston_6.R
import ru.mihmas.aston_6.presentation.recyclerview_adapter.ContactListAdapter
import ru.mihmas.aston_6.presentation.viewmodel.MainViewModel

class ContactListFragment : Fragment() {
    private val viewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }
    private val adapter by lazy { ContactListAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView(view = view)
        setupViewModel()
        setupClickListener()
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider_drawable, null)?.let {
            drawable -> dividerItemDecoration.setDrawable(drawable)
        }
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun setupViewModel() {
        viewModel.getContactList()
        viewModel.contactList.observe(viewLifecycleOwner) { list -> adapter.submitList(list) }
    }

    private fun setupClickListener() {
        adapter.onContactClickListener = {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container_view, ContactDetailFragment.newInstance(it))
                .commit()
        }
    }
    companion object {
        fun newInstance(): ContactListFragment = ContactListFragment()
    }
}