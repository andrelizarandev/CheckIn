package com.example.checkin.helpers

import android.graphics.Color
import android.widget.Button

class ComponentHandlerHelper {
	companion object {
		fun disableButton(button: Button) {
			button.isClickable = false
			button.isEnabled = false
			button.setBackgroundColor(Color.rgb(170, 170, 170))
		}
		fun enableButton(button: Button) {
			button.isClickable = true
			button.isEnabled = true
			button.setBackgroundColor(Color.rgb(43, 72, 101))
		}
	}
}