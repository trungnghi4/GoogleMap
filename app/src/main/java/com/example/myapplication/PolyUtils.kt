package com.example.myapplication

import android.content.Context
import android.graphics.Color
import com.directions.route.Route
import com.directions.route.Routing
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

class PolyUtils(
    private val context: Context,
    private val googleMap: GoogleMap,
    encodedPolyPoints: String,
    route: List<Route>
) {
    private val polylineOptions: PolylineOptions

    init {
        val polyz: List<LatLng> = decodePolyPoints(encodedPolyPoints)
//        val polyz: List<LatLng> = listOf(LatLng(10.80704,106.64366), LatLng(10.80704,106.65370 ))
        route[0].run {
            polylineOptions = PolylineOptions()
                .clickable(true)
                .addAll(points)
                .color(Color.BLACK)
                .width(5f)
        }
    }

    fun start() {
        val builder = LatLngBounds.Builder()
        for (latLng in polylineOptions.points) {
            builder.include(latLng!!)
        }
        val bounds = builder.build()
        val origin = polylineOptions.points[0]
        val destination = polylineOptions.points[polylineOptions.points.size - 1]
        googleMap.setOnMapLoadedCallback {
            googleMap.addMarker(
                MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker))
                    .position(origin)
            )
            googleMap.addMarker(
                MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_des))
                    .position(destination)
            )
            googleMap.addPolyline(polylineOptions)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
        }
    }

    private fun decodePolyPoints(encodedPath: String): ArrayList<LatLng> {
        val len = encodedPath.length
        val path = ArrayList<LatLng>()
        var index = 0
        var lat = 0
        var lng = 0
        while (index < len) {
            var result = 1
            var shift = 0
            var b: Int
            do {
                b = encodedPath[index++].code - 63 - 1
                result += b shl shift
                shift += 5
            } while (b >= 0x1f)
            lat += if (result and 1 != 0) (result shr 1).inv() else result shr 1
            result = 1
            shift = 0
            do {
                b = encodedPath[index++].code - 63 - 1
                result += b shl shift
                shift += 5
            } while (b >= 0x1f)
            lng += if (result and 1 != 0) (result shr 1).inv() else result shr 1
            path.add(LatLng(lat * 1e-5, lng * 1e-5))
        }
        return path
    }
}