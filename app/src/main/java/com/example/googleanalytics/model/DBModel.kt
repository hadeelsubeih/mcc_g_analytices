package com.example.googleanalytics.model

import android.os.Parcel
import android.os.Parcelable


data class DBModel(var id:Int,  var nameOfitem: String?, var Rating: Int, var realNum: Double,var type:String?,var Item_img: String?):Parcelable
{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nameOfitem)
        parcel.writeInt(Rating)
        parcel.writeDouble(realNum)
        parcel.writeString(type)
        parcel.writeString(Item_img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<head> {
        override fun createFromParcel(parcel: Parcel): head {
            return head(parcel)
        }

        override fun newArray(size: Int): Array<head?> {
            return arrayOfNulls(size)
        }

        val COL_ID = "id"
        val COL_NAME = "name"
        val COL_Rating= "average"
        val COL_IMAGE = "image"
        val COL_REALNUM="realnum"
        val TABLE_NAME = "shopp"
        val COL_TYPE="type"
        val TABLE_CREATE = "create table $TABLE_NAME ($COL_ID integer primary key autoincrement," +
                "$COL_NAME text not null, $COL_Rating Int,$COL_TYPE String,$COL_REALNUM int , $COL_IMAGE string)"
    }
}
