package com.example.grouptripscheduler

import android.icu.text.CaseMap
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class EventPopupActivity : AppCompatActivity(){

    private lateinit var TextTitle : EditText
    private lateinit var TextDate1 : EditText
    private lateinit var TextDate2 : EditText
    private lateinit var TextMaxPeople : EditText
    private lateinit var TextDescription : EditText
    private lateinit var TextLocation : EditText


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

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
            }
            else if(date1.isEmpty()){
                /*add error message*/
            }
            else if(date2.isEmpty()){
                /*add error message*/
            }
            else if(description.isEmpty()){

            }
            else if(location.isEmpty()){

            }
            else{
                var listgeocoder: MutableList<Address>? = null
                try {
                    listgeocoder =
                        Geocoder(this@EventPopupActivity).getFromLocationName(location, 1)
                }
                catch(e : Exception){
                    /*error message*/
                }

                if (listgeocoder != null) {
                    Event(title, date1, date2, description, location,
                        listgeocoder.get(0).latitude, listgeocoder.get(0).longitude, max, 0)
                }
            }








        }

    }
}
