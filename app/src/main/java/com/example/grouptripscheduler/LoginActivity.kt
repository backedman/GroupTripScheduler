package com.example.grouptripscheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
//import com.example.grouptripscheduler.databinding.ActivityMapsBinding


class LoginActivity : AppCompatActivity(){

    private lateinit var mMap: GoogleMap
   /////////////////////////////////// private lateinit var binding: ActivityMapsBinding
    private lateinit var Username_Input : EditText
    private lateinit var Password_Input : EditText
    private lateinit var Login : Button
    private lateinit var SignUp : Button
    private lateinit var Username : String
    private lateinit var Password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*opens login page*/
        setContentView(R.layout.login)


        /*puts the username and password into variables*/
        Username_Input = findViewById(R.id.etUsername)
        Password_Input = findViewById(R.id.etPassword)

        /*does not let the user access maps until logged in*/
        /*var accessGranted = false;
    while(!accessGranted) {*/

    }

    public fun login(Login : View){
        /*if user chooses login, check if their credentials exist in database*/
        Login.setOnClickListener {
            Username = Username_Input.text.toString()
            Password = Username_Input.text.toString()
            print("You Have Clicked Login!!!")
            /*send to database*/
            /*hash password*/

            /*receive from database*/

            /*verify login information*/

            /*if true */
                /*put information into variables (like Events joined/created) */

                /* go to map events page */
                startActivity(Intent(this@LoginActivity, MapsActivity::class.java))



            /*if false
                /*reset fields and display text saying "Username or Password is incorrect*/
             */
        }
    }

    public fun register(Register :View){

        /*if user chooses sign up, create credentials in database*/
        Register.setOnClickListener {
            Username = Username_Input.text.toString()
            Password = Username_Input.text.toString()
            print("You Have Clicked Register!!!")
            /*send to database*/
                /*hash password*/
            /*receive from database*/

            /*verify username does not already exist*/

            /*if true */
                /*put information into variables (like Events joined/created) */

            /* go to map events page */
            startActivity(Intent(this@LoginActivity, MapsActivity::class.java))



            /*if false
                /*reset fields and display text saying "Username or Password is incorrect*/
             */
        }
    }

}