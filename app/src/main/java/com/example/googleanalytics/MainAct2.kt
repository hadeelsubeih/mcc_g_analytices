package com.example.googleanalytics

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.concurrent.TimeUnit

class MainAct2  : AppCompatActivity() {
    var StopTime: Long = 0
    var StartTime:Long = 0
    internal var UserId: String? = null
    internal lateinit var sharedPreferences: SharedPreferences
    internal lateinit var Shared: SharedPreferences


    private var mFirebaseAnalytics: FirebaseAnalytics? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clotheslayout1)

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
    bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainAct2")
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
            "MainAct2 " + " page" + TimeUnit.SECONDS.convert(
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
            "time", "MainAct2" + " page" + TimeUnit.SECONDS.convert(
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
