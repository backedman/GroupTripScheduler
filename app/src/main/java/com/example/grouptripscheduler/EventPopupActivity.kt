package com.example.grouptripscheduler

import android.content.Intent
import android.icu.text.CaseMap
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.textview.MaterialTextView
import java.lang.Exception
import kotlin.properties.Delegates

class EventPopupActivity : AppCompatActivity(){

    private lateinit var TextTitle : EditText
    private lateinit var TextDate1 : EditText
    private lateinit var TextDate2 : EditText
    private lateinit var TextMaxPeople : EditText
    private lateinit var TextDescription : EditText
    private lateinit var TextLocation : EditText
    private lateinit var latlong : LatLng
    private var Latitude by Delegates.notNull<Double>()
    private var Longitude by Delegates.notNull<Double>()


    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_event_popup)

        Log.d("test", "here5")

        var extras = getIntent().extras

        Log.d("test", "here6")

        if(extras != null) {
            var latlong : LatLng = extras.get("location") as LatLng
            Latitude = latlong.latitude
            Longitude = latlong.longitude
        }
        else{
            Latitude = 0.0
            Longitude = 0.0
        }

        TextTitle = findViewById(R.id.editTextTitle)
        TextDate1 = findViewById(R.id.editTextDate)
        TextDate2 = findViewById(R.id.editTextDate2)
        TextMaxPeople = findViewById(R.id.maxPeople)
        TextDescription = findViewById(R.id.description)
        TextLocation = findViewById(R.id.location)

    }

    public fun createEvent(eventBtn : View){

        eventBtn.setOnClickListener{

            var title = TextTitle.text.toString()
            var date1 = TextDate1.text.toString()
            var date2 = TextDate2.text.toString()
            var description = TextDescription.toString()
            var location = TextLocation.toString()
            var max = 0

            try {
                max = TextMaxPeople.text.toString().toInt()
            }
            catch (e : Exception){
                /*error message*/
            }

            if(title.isEmpty()){
                /*add error message*/
                Log.d("test","no title")
            }
            else if(date1.isEmpty()){
                /*add error message*/
                Log.d("test","no date1")
            }
            else if(date2.isEmpty()){
                /*add error message*/
                Log.d("test","no date2")
            }
            else if(description.isEmpty()){
                Log.d("test","no description")
            }
            else if(location.isEmpty()){
                Log.d("test","no location")
            }
            else{

                Log.d("test","here2")

                var i = Intent(this@EventPopupActivity, MapsActivity::class.java)
                var event : Event = Event(title, date1, date2, description, location,
                    Latitude, Longitude, max, 0)
                MapsActivity.Events.add(event)
                startActivity(i)


            }








        }

    }
}
