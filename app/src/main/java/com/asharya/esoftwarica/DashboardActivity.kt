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
        DataStore.studentList.add(
            Student(
                "Luke Skywalker",
                20,
                "Male",
                "Tattoine",
                "https://images.squarespace-cdn.com/content/v1/51b3dc8ee4b051b96ceb10de/1609781087293-WX22VTUYIDWDU32P4R1Y/ke17ZwdGBToddI8pDm48kNvT88LknE-K9M4pGNO0Iqd7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1USOFn4xF8vTWDNAUBm5ducQhX-V3oVjSmr829Rco4W2Uo49ZdOtO_QXox0_W7i2zEA/image-asset.jpeg?format=2500w"
            )
        )
        DataStore.studentList.add(
            Student(
                "Obi-Wan Kenobi",
                20,
                "Male",
                "Jedi Temple",
                "https://cdn.vox-cdn.com/thumbor/KnYjrcxAozD5Q8pmr3QAXsJCwag=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/6434955/obi-wan.0.jpg"
            )
        )
    }
}