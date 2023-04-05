package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.directions.route.*
import com.example.myapplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap = googleMap

        val json =
            "[{\"copyright\":\"Map data ©2023\",\"distanceText\":\"2.7 km\",\"distanceValue\":2711,\"durationText\":\"8 mins\",\"durationValue\":456,\"endAddressText\":\"107 Trần Văn Dư, Phường 13, Tân Bình, Thành phố Hồ Chí Minh, Vietnam\",\"latLgnBounds\":{\"northeast\":{\"latitude\":10.8074847,\"longitude\":106.6550439},\"southwest\":{\"latitude\":10.8013718,\"longitude\":106.6423094}},\"length\":2711,\"name\":\"Cộng Hoà Gardens, 20 Cộng Hòa, Phường 4, Tân Bình, Thành phố Hồ Chí Minh, Vietnam to 107 Trần Văn Dư, Phường 13, Tân Bình, Thành phố Hồ Chí Minh, Vietnam\",\"points\":[{\"latitude\":10.80748,\"longitude\":106.65374},{\"latitude\":10.80742,\"longitude\":106.65444},{\"latitude\":10.80738,\"longitude\":106.65491},{\"latitude\":10.80737,\"longitude\":106.65504},{\"latitude\":10.80737,\"longitude\":106.65504},{\"latitude\":10.80687,\"longitude\":106.655},{\"latitude\":10.80624,\"longitude\":106.65494},{\"latitude\":10.80624,\"longitude\":106.65494},{\"latitude\":10.80557,\"longitude\":106.65487},{\"latitude\":10.80433,\"longitude\":106.65478},{\"latitude\":10.80389,\"longitude\":106.65474},{\"latitude\":10.80314,\"longitude\":106.65467},{\"latitude\":10.80307,\"longitude\":106.65466},{\"latitude\":10.8029,\"longitude\":106.65464},{\"latitude\":10.80229,\"longitude\":106.65459},{\"latitude\":10.80188,\"longitude\":106.65456},{\"latitude\":10.8016,\"longitude\":106.65454},{\"latitude\":10.80137,\"longitude\":106.65452},{\"latitude\":10.80137,\"longitude\":106.65452},{\"latitude\":10.80148,\"longitude\":106.65333},{\"latitude\":10.80152,\"longitude\":106.65286},{\"latitude\":10.80153,\"longitude\":106.65276},{\"latitude\":10.80154,\"longitude\":106.65259},{\"latitude\":10.80163,\"longitude\":106.65168},{\"latitude\":10.8017,\"longitude\":106.65084},{\"latitude\":10.80176,\"longitude\":106.65009},{\"latitude\":10.80178,\"longitude\":106.64989},{\"latitude\":10.8018,\"longitude\":106.64963},{\"latitude\":10.80187,\"longitude\":106.64886},{\"latitude\":10.80191,\"longitude\":106.64831},{\"latitude\":10.80194,\"longitude\":106.64794},{\"latitude\":10.80196,\"longitude\":106.6478},{\"latitude\":10.80199,\"longitude\":106.64747},{\"latitude\":10.80201,\"longitude\":106.64703},{\"latitude\":10.80204,\"longitude\":106.64681},{\"latitude\":10.80205,\"longitude\":106.64663},{\"latitude\":10.80209,\"longitude\":106.64628},{\"latitude\":10.80215,\"longitude\":106.64572},{\"latitude\":10.80218,\"longitude\":106.64533},{\"latitude\":10.80218,\"longitude\":106.64521},{\"latitude\":10.80219,\"longitude\":106.64506},{\"latitude\":10.8022,\"longitude\":106.64493},{\"latitude\":10.80221,\"longitude\":106.64482},{\"latitude\":10.80222,\"longitude\":106.64463},{\"latitude\":10.80226,\"longitude\":106.64428},{\"latitude\":10.8023,\"longitude\":106.64363},{\"latitude\":10.8024,\"longitude\":106.64231},{\"latitude\":10.8024,\"longitude\":106.64231},{\"latitude\":10.80303,\"longitude\":106.6424},{\"latitude\":10.80452,\"longitude\":106.64262},{\"latitude\":10.80475,\"longitude\":106.64266},{\"latitude\":10.80501,\"longitude\":106.64267},{\"latitude\":10.80615,\"longitude\":106.64278},{\"latitude\":10.80615,\"longitude\":106.64278},{\"latitude\":10.80615,\"longitude\":106.6428},{\"latitude\":10.8061,\"longitude\":106.64331},{\"latitude\":10.8061,\"longitude\":106.64331},{\"latitude\":10.80682,\"longitude\":106.64334},{\"latitude\":10.80683,\"longitude\":106.64334}],\"polyOptions\":{\"zza\":[{\"latitude\":10.80748,\"longitude\":106.65374},{\"latitude\":10.80742,\"longitude\":106.65444},{\"latitude\":10.80738,\"longitude\":106.65491},{\"latitude\":10.80737,\"longitude\":106.65504},{\"latitude\":10.80737,\"longitude\":106.65504},{\"latitude\":10.80687,\"longitude\":106.655},{\"latitude\":10.80624,\"longitude\":106.65494},{\"latitude\":10.80624,\"longitude\":106.65494},{\"latitude\":10.80557,\"longitude\":106.65487},{\"latitude\":10.80433,\"longitude\":106.65478},{\"latitude\":10.80389,\"longitude\":106.65474},{\"latitude\":10.80314,\"longitude\":106.65467},{\"latitude\":10.80307,\"longitude\":106.65466},{\"latitude\":10.8029,\"longitude\":106.65464},{\"latitude\":10.80229,\"longitude\":106.65459},{\"latitude\":10.80188,\"longitude\":106.65456},{\"latitude\":10.8016,\"longitude\":106.65454},{\"latitude\":10.80137,\"longitude\":106.65452},{\"latitude\":10.80137,\"longitude\":106.65452},{\"latitude\":10.80148,\"longitude\":106.65333},{\"latitude\":10.80152,\"longitude\":106.65286},{\"latitude\":10.80153,\"longitude\":106.65276},{\"latitude\":10.80154,\"longitude\":106.65259},{\"latitude\":10.80163,\"longitude\":106.65168},{\"latitude\":10.8017,\"longitude\":106.65084},{\"latitude\":10.80176,\"longitude\":106.65009},{\"latitude\":10.80178,\"longitude\":106.64989},{\"latitude\":10.8018,\"longitude\":106.64963},{\"latitude\":10.80187,\"longitude\":106.64886},{\"latitude\":10.80191,\"longitude\":106.64831},{\"latitude\":10.80194,\"longitude\":106.64794},{\"latitude\":10.80196,\"longitude\":106.6478},{\"latitude\":10.80199,\"longitude\":106.64747},{\"latitude\":10.80201,\"longitude\":106.64703},{\"latitude\":10.80204,\"longitude\":106.64681},{\"latitude\":10.80205,\"longitude\":106.64663},{\"latitude\":10.80209,\"longitude\":106.64628},{\"latitude\":10.80215,\"longitude\":106.64572},{\"latitude\":10.80218,\"longitude\":106.64533},{\"latitude\":10.80218,\"longitude\":106.64521},{\"latitude\":10.80219,\"longitude\":106.64506},{\"latitude\":10.8022,\"longitude\":106.64493},{\"latitude\":10.80221,\"longitude\":106.64482},{\"latitude\":10.80222,\"longitude\":106.64463},{\"latitude\":10.80226,\"longitude\":106.64428},{\"latitude\":10.8023,\"longitude\":106.64363},{\"latitude\":10.8024,\"longitude\":106.64231},{\"latitude\":10.8024,\"longitude\":106.64231},{\"latitude\":10.80303,\"longitude\":106.6424},{\"latitude\":10.80452,\"longitude\":106.64262},{\"latitude\":10.80475,\"longitude\":106.64266},{\"latitude\":10.80501,\"longitude\":106.64267},{\"latitude\":10.80615,\"longitude\":106.64278},{\"latitude\":10.80615,\"longitude\":106.64278},{\"latitude\":10.80615,\"longitude\":106.6428},{\"latitude\":10.8061,\"longitude\":106.64331},{\"latitude\":10.8061,\"longitude\":106.64331},{\"latitude\":10.80682,\"longitude\":106.64334},{\"latitude\":10.80683,\"longitude\":106.64334}],\"zzb\":1.0,\"zzc\":-12477447,\"zzd\":0.0,\"zze\":true,\"zzf\":false,\"zzg\":false,\"zzh\":{\"zzb\":0},\"zzi\":{\"zzb\":0},\"zzj\":0,\"zzl\":[]},\"segments\":[{\"distance\":0.143,\"instruction\":\"Head east on Đ. C2Restricted usage road\",\"length\":143,\"start\":{\"latitude\":10.8074847,\"longitude\":106.6537434}},{\"distance\":0.269,\"instruction\":\"Turn right toward Đ. 18ERestricted usage road\",\"length\":126,\"start\":{\"latitude\":10.8073697,\"longitude\":106.6550439}},{\"distance\":0.812,\"instruction\":\"Continue onto Đ. 18EPartial restricted usage road\",\"length\":543,\"start\":{\"latitude\":10.80624,\"longitude\":106.6549373}},{\"distance\":2.151,\"instruction\":\"Turn right onto Đ. Cộng HòaPass by Siêu thị Thế Giới Di Động (on the right in 950m)\",\"length\":1339,\"start\":{\"latitude\":10.8013718,\"longitude\":106.6545235}},{\"distance\":2.571,\"instruction\":\"Turn right onto Thân Nhân TrungPass by Công Ty Cổ Phần Hải Kim (on the right)\",\"length\":420,\"start\":{\"latitude\":10.8024039,\"longitude\":106.6423094}},{\"distance\":2.629,\"instruction\":\"Thân Nhân Trung turns right and becomes Mai Lão Bạng\",\"length\":58,\"start\":{\"latitude\":10.8061539,\"longitude\":106.6427823}},{\"distance\":2.711,\"instruction\":\"Turn leftRestricted usage roadDestination will be on the right\",\"length\":82,\"start\":{\"latitude\":10.8060996,\"longitude\":106.6433141}}]}]"
        val listType = object : TypeToken<List<Route>>() {}.type
        val listRoute = Gson().fromJson<List<Route>>(json, listType)

        val polyUtils = PolyUtils(
            this,
            mMap,
            "",
            listRoute
//            "{punAgqyhNIgAWAeE[iBKLh@VdA\\z@t@rALr@SrDdC@BHj@lDPvB?t@Ax@DRBf@Df@f@lFdHcBp@QnDy@jBi@bCiA|E_CrDaBhAu@BIWQ_BmCQF_C~@"
        )
        polyUtils.start()
    }

    private var targetLocation: LatLng = LatLng(10.80704, 106.64366)
    private var currentDirection: Polyline? = null

    private fun drawPoly() {
        val position = LatLng(10.80704, 106.65370)
        Routing.Builder()
            .key(getString(R.string.google_maps_key))
            .waypoints(listOf(position, targetLocation))
            .travelMode(AbstractRouting.TravelMode.DRIVING)
            .withListener(object : RoutingListener {
                override fun onRoutingCancelled() {
                    // No-op
                }

                override fun onRoutingStart() {
                    // No-op
                    Toast.makeText(
                        this@MapsActivity,
                        "Finding Route...",
                        Toast.LENGTH_LONG
                    ).show();

                }

                override fun onRoutingFailure(exception: RouteException?) {
                    // No-op
                    Toast.makeText(
                        this@MapsActivity,
                        exception.toString(),
                        Toast.LENGTH_LONG
                    ).show();
                }

                override fun onRoutingSuccess(
                    routes: ArrayList<Route>?,
                    shortestRouteIndex: Int
                ) {
                    currentDirection?.remove()
                    routes?.get(shortestRouteIndex)?.run {
                        polyOptions = this@MapsActivity.let { context ->
                            ContextCompat.getColor(
                                context,
                                R.color.colorDirectionStroke
                            )
                        }?.let { color ->
                            PolylineOptions()
                                .color(color)
                                .width(1f)
                                .addAll(points)
                        }
                        polyOptions?.let {
                            currentDirection = mMap.addPolyline(polyOptions)
                            mMap.addMarker(
                                MarkerOptions()
                                    .position(targetLocation)
                                    .title("ABC")
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.img))
                                    .anchor(0.5F, 0.5F)
                            )
                                ?.showInfoWindow()

                        }
                    }
                }

            })
            .build()
            .execute()
    }
}