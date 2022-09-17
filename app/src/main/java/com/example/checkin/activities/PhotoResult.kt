package com.example.checkin.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.checkin.MainActivity
import com.example.checkin.R
import com.example.checkin.helpers.ComponentHandlerHelper

class PhotoResult : AppCompatActivity() {

	// Codes
	private val CAMERA_REQUEST_CODE = 1
	private var REQUEST_CODE_CAMERA_PERMISSION = 2

	// Permissions
	private val readPermission = Manifest.permission.READ_EXTERNAL_STORAGE
	private val cameraPermission = Manifest.permission.CAMERA

	// Components
	private lateinit var llIdFront: LinearLayout
	private lateinit var llIdBack: LinearLayout
	private lateinit var ivIdFrontResult: ImageView
	private lateinit var ivIdBackResult: ImageView
	private lateinit var tvIdFront: TextView
	private lateinit var tvIdBack: TextView
	private lateinit var btnConfirmPhotos: Button
	private lateinit var btnGoBackFromPhotoResult: Button

	// Vars
	private var currentImage = ""

	// Helpers
	private val componentHandlerHelper = ComponentHandlerHelper

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_photo_result)
		checkPermissions(false)
		getComponents()
		addListeners()
		startActivitySettings()
	}

	private fun startActivitySettings () {
		this.title = "Tomar fotografías"
		componentHandlerHelper.disableButton(btnConfirmPhotos)
	}

	private fun getComponents () {
		llIdFront = findViewById(R.id.ll_id_front)
		llIdBack = findViewById(R.id.ll_id_back)
		ivIdFrontResult = findViewById(R.id.iv_id_front_result)
		ivIdBackResult = findViewById(R.id.iv_id_back_result)
		tvIdFront = findViewById(R.id.tv_id_front)
		tvIdBack = findViewById(R.id.tv_id_back)
		btnConfirmPhotos = findViewById(R.id.btn_confirm_photos)
		btnGoBackFromPhotoResult = findViewById(R.id.btn_go_back_from_photo_result)
	}

	private fun addListeners () {
		llIdFront.setOnClickListener {
			currentImage = "front"
			checkPermissions(true)
		}
		llIdBack.setOnClickListener {
			currentImage = "back"
			checkPermissions(true)
		}
		btnConfirmPhotos.setOnClickListener {
			val intent = Intent(this, PhotosSent::class.java)
			startActivity(intent)
		}
		btnGoBackFromPhotoResult.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
		}
	}

	private fun checkPermissions (willStart:Boolean) {
		val isCameraPermissionAvailable =
			ContextCompat.checkSelfPermission(applicationContext, cameraPermission) !=
				PackageManager.PERMISSION_GRANTED
		val isReadPermissionAvailable =
			ContextCompat.checkSelfPermission(applicationContext, readPermission) !=
				PackageManager.PERMISSION_GRANTED
		if (isCameraPermissionAvailable || isReadPermissionAvailable) {
			var permissionsRequest = listOf(readPermission, cameraPermission)
			ActivityCompat.requestPermissions(this, permissionsRequest.toTypedArray(), REQUEST_CODE_CAMERA_PERMISSION)
		} else if (willStart) startCamera()
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		if (
			grantResults[0] == PackageManager.PERMISSION_GRANTED &&
			grantResults[1] == PackageManager.PERMISSION_GRANTED
		) startCamera()
		else Toast.makeText(
			applicationContext,
			"No has concedido permisos para el correcto funcionamiento",
			Toast.LENGTH_SHORT
		).show()
	}

	private fun startCamera () {
		val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
		startActivityForResult(intent, CAMERA_REQUEST_CODE)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (resultCode == Activity.RESULT_OK) {
			when (requestCode) {
				CAMERA_REQUEST_CODE -> {
					val bitmap = data?.extras?.get("data") as Bitmap
					if (currentImage == "front") {
						tvIdFront.visibility = View.GONE
						ivIdFrontResult.visibility = View.VISIBLE
						ivIdFrontResult.setImageBitmap(bitmap)
					} else {
						tvIdBack.visibility = View.GONE
						ivIdBackResult.visibility = View.VISIBLE
						ivIdBackResult.setImageBitmap(bitmap)
					}
					if (
						ivIdFrontResult.visibility == View.VISIBLE &&
						ivIdBackResult.visibility == View.VISIBLE
					) { componentHandlerHelper.enableButton(btnConfirmPhotos) }
				}
			}
		}
	}

}