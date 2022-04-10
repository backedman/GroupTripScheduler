package com.example.grouptripscheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
//import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.TAG

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.example.grouptripscheduler.databinding.ActivityMapsBinding


class LoginActivity : AppCompatActivity(){

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
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


        /*setupAuthButton(UserData)
        UserData.isSignedIn.observe(this, Observer<Boolean> { isSignedUp ->
            // update UI
            Log.i(TAG, "isSignedIn changed : $isSignedUp")

            if (isSignedUp) {
                fabAuth.setImageResource(R.drawable.ic_baseline_lock_open)
            } else {
                fabAuth.setImageResource(R.drawable.ic_baseline_lock)
            }
        }) */

    }

    public fun login(Login : View){
        /*if user chooses login, check if their credentials exist in database*/
        Login.setOnClickListener {
            var Username = Username_Input.text.toString()
            var Password = Username_Input.text.toString()

            /*hash password*/

            print("You Have Clicked Login!!!")
            /*send to database*/


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

    private fun setupAuthButton(userData: UserData) {

        // register a click listener
        /*fabAuth.setOnClickListener { view ->

            val authButton = view as FloatingActionButton

            if (userData.isSignedIn.value!!) {
                authButton.setImageResource(R.drawable.ic_baseline_lock_open)
                Backend.signOut()
            } else {
                authButton.setImageResource(R.drawable.ic_baseline_lock_open)
                Backend.signIn(this)
            } */
        }
}





