package com.example.checkin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.checkin.MainActivity
import com.example.checkin.R

class PhotosSent : AppCompatActivity() {

	private lateinit var btnGoBackFromConfirmSentPhotos:Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_photos_sent)
		getComponents()
		addListeners()
		this.title = "Imágenes mandadas"
	}

	fun getComponents () {
		btnGoBackFromConfirmSentPhotos = findViewById(R.id.btn_go_back_from_confirm_sent_photos)
	}

	fun addListeners () {
		btnGoBackFromConfirmSentPhotos.setOnClickListener { goBackFromPhotosSent() }
	}

	private fun goBackFromPhotosSent() {
		val intent = Intent(this, MainActivity::class.java)
		startActivity(intent)
	}

}