package com.asharya.esoftwarica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asharya.esoftwarica.fragments.AboutFragment
import com.asharya.esoftwarica.fragments.AddStudentFragment
import com.asharya.esoftwarica.fragments.HomeFragment
import com.asharya.esoftwarica.models.Student
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val homeFragment = HomeFragment()
        val aboutFragment = AboutFragment()
        val addStudentFragment = AddStudentFragment()
        addDummyStudent()

        setFragment(homeFragment)

        val bottomNavView : BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setFragment(homeFragment)
                R.id.miAddStudent -> setFragment(addStudentFragment)
                R.id.miAboutUs -> setFragment(aboutFragment)
            }
            true
        }
    }

    private fun setFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }

    private fun addDummyStudent()  {
        DataStore.studentList.add(
            Student(
                "Asharya Pandey",
                20,
                "Male",
                "Banepa",
                "https://lumiere-a.akamaihd.net/v1/images/darth-vader_6bda9114_e7820538.jpeg?region=0%2C70%2C1400%2C788"
            )
        )
    }
}