package com.example.grouptripscheduler

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.grouptripscheduler.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.Marker
import java.lang.Exception


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var Username_Input : EditText
    private lateinit var Password_Input : EditText
    private lateinit var Login : Button
    private lateinit var SignUp : Button
    private lateinit var Username : String
    private lateinit var Password : String
    companion object {
        var Events: MutableList<Event> = mutableListOf<Event>()

        init {
            Events.add(Event("Trip to Sydney", "10/4/22", "10/12/22",
                "we are going to sydney uwu",
                "Sydney", -34.0, 151.0, 10, 1))

            Events.add(Event("Skii Trip", "10/12/22", "10/13/22",
                "skii trip :O", "Liberty Mountain Resort",
                39.763714, -77.375664, 3, 2))


            Log.d("test", "Bruh3")
            Events.add(Event("Canada Hiking", "8/12/22", "8/23/22",
                "Let's visit the great beyond together!", "Ottowa",
                45.256581, -75.764582, 2, 3))
        }

        fun addEvent(event : Event) {
            Events.add(event)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*sets up the map*/
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*loads events*/
        print("Bruh")

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

        mMap.setOnMapLongClickListener{
            Log.d("test", "here1")
            openPopUp(it)
        }




        var markers : HashMap<Marker, Event> = hashMapOf<Marker, Event>()
        for (event in Events) {
            val eventPos = LatLng(event.Latitude, event.Longitude)
            var marker : Marker = mMap.addMarker(MarkerOptions().position(eventPos).title(event.eventTitle))
            markers.put(marker, event)
        }

        mMap.setOnMarkerClickListener { marker : Marker ->
            var i = Intent(this@MapsActivity, EventPopupActivity::class.java)
            i.putExtra("event", markers.get(marker) as Bundle?)
            startActivity(i)
            true
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(Events[0].Latitude, Events[0].Longitude)))



    }



    private fun openPopUp(Point : LatLng){

        /*open popup*/
        Log.d("test","here2")
        var i = Intent(this@MapsActivity, EventPopupActivity::class.java)
        Log.d("test","here3")
        i.putExtra("location", Point)
        startActivity(i)

    }
}

