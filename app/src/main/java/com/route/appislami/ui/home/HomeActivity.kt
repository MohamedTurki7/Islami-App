package com.route.appislami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.appislami.R
import com.route.appislami.ui.home.hadeth.HadethFragment
import com.route.appislami.ui.home.quran.QuranFragment
import com.route.appislami.ui.home.radio.RadioFragment
import com.route.appislami.ui.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.Navigation_home)
        bottomNav.selectedItemId = R.id.Navigation_quran
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Navigation_quran -> {
                    showTab(QuranFragment())
                }

                R.id.Navigation_hadeth -> {
                    showTab(HadethFragment())
                }

                R.id.Navigation_tasbeh -> {
                    showTab(TasbehFragment())
                }

                R.id.Navigation_radio -> {
                    showTab(RadioFragment())
                }
            }

            return@setOnItemSelectedListener true
        }

    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Fragment_container, fragment)
            .commit()
    }
}