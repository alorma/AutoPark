package com.alorma.autopark

import android.content.Intent
import android.net.Uri
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.model.Action
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Header
import androidx.car.app.model.ItemList
import androidx.car.app.model.Metadata
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.navigation.model.PlaceListNavigationTemplate

class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {
  override fun onGetTemplate(): Template {

    return PlaceListMapTemplate.Builder()
      .setHeaderAction(Action.APP_ICON)
      .setLoading(false)
      .setOnContentRefreshListener {
        invalidate()
      }
      .setItemList(
        ItemList.Builder()
          .addItem(
            buildPlace(
              title = "Place #1",
              carLocation = CarLocation.create(41.557475, 2.0140157),
            )
          )
          .addItem(
            buildPlace(
              title = "Place #2",
              carLocation = CarLocation.create(41.553592, 2.0175253),
            )
          )
          .build()
      )
      .build()
  }

  private fun buildPlace(
    title: String,
    carLocation: CarLocation
  ): Row {
    return Row.Builder()
      .setTitle(title)
      .setBrowsable(true)
      .setMetadata(
        Metadata.Builder()
          .setPlace(
            Place.Builder(carLocation)
              .setMarker(
                PlaceMarker.Builder()
                  .setColor(CarColor.PRIMARY)
                  .build()
              )
              .build()
          )
          .build()
      )
      .setOnClickListener { onClickNavigate(carLocation) }
      .build()
  }

  private fun onClickNavigate(place: CarLocation) {
    val latitude = place.latitude
    val longitude = place.longitude
    val intent = Intent(CarContext.ACTION_NAVIGATE, Uri.parse("geo:0,0?q=${latitude},${longitude})"))
    intent.setPackage("com.google.android.apps.maps")
    carContext.startCarApp(intent)
  }
}
