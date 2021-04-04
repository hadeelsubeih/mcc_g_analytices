package com.example.googleanalytics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.googleanalytics.db.Adapter
import com.example.googleanalytics.model.head
import kotlinx.android.synthetic.main.clotheslayout1.view.*

class FragmentClothes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.clotheslayout1, container, false)
        val datacolthes = mutableListOf<head>()
        fun datacolthes() {


            datacolthes.add(
                head(   0,
                    "Cotton blouse",
                    4F,
                    50.0,
                    "colthes",
                    R.drawable.clo1
                )
            )
            datacolthes.add(
                head(
                    0,
                    "kids dresses",
                    3F,
                    200.2,
                    "colthes",
                    R.drawable.clo2                )
            )
            datacolthes.add(
                head(
                    0,
                    "Evening Dress",
                    4F,
                    100.0,
                    "colthes",
                    R.drawable.clo3                )
            )
            datacolthes.add(
                head(
                    0,
                    "My boy's kit",
                    4F,
                    80.0,
                    "colthes",
                    R.drawable.clo4                )
            )

        }
        datacolthes()
        root.clothess.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val Clothess =
            Adapter(activity!!,datacolthes)
        root.clothess.adapter = Clothess
        return root
    }


}