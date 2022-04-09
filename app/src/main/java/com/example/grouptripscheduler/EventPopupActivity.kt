package com.example.grouptripscheduler

import android.icu.text.CaseMap
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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
            var max = TextMaxPeople.text.toString().toInt()
            var description = TextDescription.toString()
            var location = TextLocation.toString()

            if(title.isEmpty()){
                /*add error message*/
            }


        }

    }
}
