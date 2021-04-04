package com.example.googleanalytics

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_details.*
import java.util.concurrent.TimeUnit

class detailes : AppCompatActivity() {
    var StopTime: Long = 0
    var StartTime:Long = 0
    internal var UserId: String? = null
    internal lateinit var sharedPreferences: SharedPreferences
    internal lateinit var Shared: SharedPreferences
    private var mFirebaseAnalytics: FirebaseAnalytics? = null


    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val img=  intent.getIntExtra("imgs",1)
        ImageView.setImageResource(img)

        val names= intent.getStringExtra("names")
        nameOfitem.text= names
        val price= intent.getIntExtra("price",1)
        realNum.text= price.toString()

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        sharedPreferences = getSharedPreferences("userID", Context.MODE_PRIVATE)
        Shared = getSharedPreferences("userID", Context.MODE_PRIVATE)

        UserId = Shared.getString("userId", "1")
        add("2","dodo")
        track("main screen")

    }
    fun track(screenName:String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "detailes")
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
            "detailes " + " page" + TimeUnit.SECONDS.convert(
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
