package com.alorma.autopark

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class HelloWorldSession : Session() {

  override fun onCreateScreen(intent: Intent): Screen {
    return HelloWorldScreen(carContext)
  }
}