package com.example.checkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.checkin.fragments.RecentFragment
import com.example.checkin.fragments.SettingsFragment
import com.example.checkin.fragments.StatsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

	// Components
	private lateinit var bottomNavigationBar:BottomNavigationView

	// Fragments
	private val recentFragment = RecentFragment()
	private val statsFragment = StatsFragment()
	private val settingsFragment = SettingsFragment()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		getComponents()
		addListeners()
		makeCurrentFragment(recentFragment)
		this.title = "Inicio"
	}

	private fun makeCurrentFragment (fragment: Fragment) {
		supportFragmentManager.beginTransaction().apply {
			replace(R.id.fl_wrapper, fragment)
			commit()
		}
	}

	private fun getComponents () {
		bottomNavigationBar = findViewById(R.id.bottom_navigation_bar)
	}

	private fun addListeners () {
		bottomNavigationBar.setOnNavigationItemSelectedListener {
			when (it.itemId) {
				R.id.ic_recents -> makeCurrentFragment(recentFragment)
				R.id.ic_stats -> makeCurrentFragment(statsFragment)
				R.id.ic_settings -> makeCurrentFragment(settingsFragment)
			}
			true
		}
	}

}