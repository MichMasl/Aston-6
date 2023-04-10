package ru.mihmas.aston_6.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mihmas.aston_6.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, ContactListFragment.newInstance())
            .commit()
    }
}