package com.example.googleanalytics

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.googleanalytics.db.Adapter
import com.example.googleanalytics.model.head
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.clotheslayout1.view.*
import kotlinx.android.synthetic.main.foodlayout.view.*
import java.util.concurrent.TimeUnit

class FragmentFood : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.clotheslayout1, container, false)
        val datafood = mutableListOf<head>()
        fun datafood() {


            datafood.add(
                head(   0,
                    "chickens",
                    4F,
                    30.0,
                    "food",
                    R.drawable.food1
                )
            )
            datafood.add(
                head(
                    0,
                    "humborger",
                    4F,
                    15.2,
                    "food",
                    R.drawable.food2                )
            )
            datafood.add(
                head(
                    0,
                    "Valet meat",
                    4F,
                    20.0,
                    "food",
                    R.drawable.food3                )
            )
            datafood.add(
                head(
                    0,
                    "Shrimp",
                    4F,
                    80.0,
                    "food",
                    R.drawable.food4                )
            )

        }
        datafood()
        root.clothess.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val Food =
            Adapter(activity!!,datafood)
        root.clothess.adapter = Food
        return root
    }


}