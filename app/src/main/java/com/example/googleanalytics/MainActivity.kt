package com.example.googleanalytics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.R.attr.name
import android.R.id
import android.content.Context
import android.content.SharedPreferences
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.datatype.DatatypeConstants.SECONDS
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import java.util.concurrent.TimeUnit
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import java.util.*


class MainActivity : AppCompatActivity() {
    var StopTime: Long = 0
    var StartTime:Long = 0
    internal var UserId: String? = null
    internal lateinit var sharedPreferences: SharedPreferences
    internal lateinit var Shared: SharedPreferences


    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        sharedPreferences = getSharedPreferences("userID", Context.MODE_PRIVATE)
        Shared = getSharedPreferences("userID", Context.MODE_PRIVATE)

        UserId = Shared.getString("userId", "1")
        Log.d("hadeel", UserId!!)
        if (UserId == "1") {

            val id = UUID.randomUUID()
            Log.d("hadeel", id.toString())
            val share = sharedPreferences.edit()
            share.putString("userId ", id.toString())
            Log.d("hadeel", id.toString())
            share.commit()
        }
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        food1.setOnClickListener {
            var i=Intent(this,MainAct2::class.java)
            startActivity(i)


        }
        Electronic.setOnClickListener {
            var i=Intent(this,MainAct2::class.java)
            startActivity(i)


        }
        Clothes2.setOnClickListener {
            var i=Intent(this,MainAct2::class.java)
            startActivity(i)


        }

        add("2","dodo")
        track("main screen")
    }
    fun track(screenName:String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }

    fun add(id: String,name: String){
        val bundle = Bundle()
        bundle.putString("id", id)
        bundle.putString("name", name)
        mFirebaseAnalytics?.logEvent("add" ,bundle)




    }
    override fun onPause() {
        super.onPause()

        StopTime = System.currentTimeMillis()
        val b = Bundle()
        b.putString(
            "time",
            "Main " + " page" + TimeUnit.SECONDS.convert(
                StopTime - StartTime,
                TimeUnit.MILLISECONDS
            ).toString() + " Seconds"
        )
        Log.d(
            "h",
            TimeUnit.SECONDS.convert(
                StopTime - StartTime,
                TimeUnit.MILLISECONDS
            ).toString() + " Seconds"
        )
        mFirebaseAnalytics?.setUserProperty(
            "time", "Main" + " page" + TimeUnit.SECONDS.convert(
                StopTime - StartTime, TimeUnit.MILLISECONDS
            ).toString() + " Seconds"
        )
        mFirebaseAnalytics?.logEvent("time", b)
        Log.d("h", "done successfully")


    }


    override fun onResume() {
        // TODO Auto-generated method stub
        super.onResume()

        //update foreground time
        StartTime = System.currentTimeMillis()
    }
}
