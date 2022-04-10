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
    public lateinit var Events : MutableList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*sets up the map*/
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Events = mutableListOf<Event>()

        /*loads events*/
        Log.d("test", "Bruh1")
        Events.add(Event("Trip to Sydney", "10/4/22", "10/12/22",
            "we are going to sydney uwu",
            "Sydney", -34.0, 151.0, 10, 1))
        Log.d("test", Events[0].eventTitle)

        Log.d("test", "Bruh2")
        addEvent("Skii Trip", "10/12/22", "10/13/22",
            "skii trip :O", "Liberty Mountain Resort",
            3, 2)?.let {
            Events.add(
                it
            )
        }
        Log.d("test", Events.size.toString())

        Log.d("test", "Bruh3")
        addEvent("Canada Hiking", "8/12/22", "8/23/22",
            "Let's visit the great beyond together!", "Ontario",
            5, 2)?.let {
            Events.add(
                it
            )
        }
        Log.d("test", Events.size.toString())
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    private fun addEvent(title : String, date1: String, date2: String,
                               description: String, address : String, max : Int, curr : Int) : Event? {

        var listgeocoder: MutableList<Address>? = null
        try {
            listgeocoder =
                Geocoder(this@MapsActivity).getFromLocationName(address, 1)
        }
        catch(e : Exception){
            /*error message*/
            Log.d("test", "ERROR")
        }

        if (listgeocoder != null) {
            return Event(title, date1, date2, description, address,
                listgeocoder.get(0).latitude, listgeocoder.get(0).longitude, 3, 1)
        }

        return null

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

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        for (event in Events) {
            val eventPos = LatLng(event.Latitude, event.Longitude)
            mMap.addMarker(MarkerOptions().position(eventPos).title(event.eventTitle))
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    public fun eventBtnPress(addButton : View){
        addButton.setOnClickListener {

            /*open popup*/
            startActivity(Intent(this@MapsActivity, EventPopupActivity::class.java))

        }
    }



    private fun openPopUp(Point : LatLng){

        /*open popup*/
        Log.d("test","here2")
        var i = Intent(this@MapsActivity, EventPopupActivity::class.java)
        Log.d("test","here3")
        //i.putExtra("location", Point)
        startActivity(i)


    }
}