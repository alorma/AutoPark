package com.alorma.autopark

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.Header
import androidx.car.app.model.Item
import androidx.car.app.model.ItemList
import androidx.car.app.model.Template
import androidx.car.app.navigation.model.PlaceListNavigationTemplate

class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {
  override fun onGetTemplate(): Template {

    return PlaceListNavigationTemplate.Builder()
      .setHeader(
        Header.Builder()
          .setTitle("Hello Alorma!")
          .setStartHeaderAction(Action.APP_ICON)
          .build()
      )
      .build()
  }
}