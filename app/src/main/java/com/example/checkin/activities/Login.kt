package com.example.checkin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.checkin.R
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {

	// Components
	lateinit var etUsername:TextInputLayout
	lateinit var etPassword:TextInputLayout
	lateinit var btnLogin:Button

	// Vars

	// Data

	// Const

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
		getComponents()
		addListeners()
	}

	private fun getComponents () {
		etUsername = findViewById(R.id.etUsername)
		etPassword = findViewById(R.id.etPassword)
		btnLogin = findViewById(R.id.btnLogin)
	}

	private fun addListeners () {
		btnLogin.setOnClickListener{ submitLogin() }
	}

	private fun submitLogin () {

	}

}