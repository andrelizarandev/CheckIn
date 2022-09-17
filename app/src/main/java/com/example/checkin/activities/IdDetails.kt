package com.example.checkin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.checkin.MainActivity
import com.example.checkin.R

class IdDetails : AppCompatActivity() {

	private lateinit var btnGetBackFromIdDetails:Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_id_details)
		getComponents()
		addListeners()
		this.title = "Detalle de Identificación"
	}

	private fun getComponents () {
		btnGetBackFromIdDetails = findViewById(R.id.btn_get_back_from_id_details)
	}

	private fun addListeners () {
		btnGetBackFromIdDetails.setOnClickListener { goBackFromDetails() }
	}

	private fun goBackFromDetails () {
		val intent = Intent(this, MainActivity::class.java)
		startActivity(intent)
	}

}