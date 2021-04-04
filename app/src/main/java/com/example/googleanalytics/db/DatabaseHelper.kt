package com.example.final_project

import android.app.Activity
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.googleanalytics.model.DBModel

class DatabaseHelper(activity: Activity) :
    SQLiteOpenHelper(activity, DATABASE_NAME, null, DATABASE_VERSION) {

    private val db: SQLiteDatabase = this.writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DBModel.TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("Drop table if exists ${DBModel.TABLE_NAME}")
        onCreate(db)
    }

    //==============================================================================================
    //DML

    fun insertPro(nameOfitem: String,Rating: Int,realNum: Double,type:String, Item_img:String): Boolean {
        val cv = ContentValues()
        cv.put(DBModel.COL_NAME, nameOfitem)
        cv.put(DBModel.COL_Rating,Rating )
        cv.put(DBModel.COL_REALNUM,realNum )
        cv.put(DBModel.COL_TYPE, type)
        cv.put(DBModel.COL_IMAGE, Item_img)
        return db.insert(DBModel.TABLE_NAME, null, cv) > 0
    }
    fun getAllPro(): ArrayList<DBModel> {
        val data = ArrayList<DBModel>()
        val c =
            db.rawQuery("select * from ${DBModel.TABLE_NAME} order by ${DBModel.COL_ID} desc", null)
        c.moveToFirst()
        while (!c.isAfterLast) {
            val s = DBModel(
                c.getInt(0),
                c.getString(1),
                c.getInt(2),
                c.getDouble(3),
                c.getString(4),
                c.getString(5)
            )
            data.add(s)
            c.moveToNext()
        }
        c.close()
        return data
    }
      fun getRes():ArrayList<DBModel>{
    val data = ArrayList<DBModel>()
          val type="food"
    val n =
        db.rawQuery("select * from ${DBModel.TABLE_NAME}  where ${DBModel.COL_TYPE} = '$type'  order by ${DBModel.COL_ID} desc", null)
    n.moveToFirst()
    while (!n.isAfterLast) {
        val s = DBModel(
            n.getInt(0),
            n.getString(1),
            n.getInt(2),
            n.getDouble(3),
            n.getString(4),
            n.getString(5)
        )
        data.add(s)
        n.moveToNext()
    }
          n.close()
          return data
      }
    fun getRe(type: String):String{
        val data = type
        db.rawQuery("select * from ${DBModel.TABLE_NAME} where ${DBModel.COL_TYPE} = '$type'  order by ${DBModel.COL_ID} desc",null)
        return data
    }

    fun deletePro(id:Int) : Boolean{
        return db.delete(DBModel.TABLE_NAME,"${DBModel.COL_ID} = $id",null)>0
    }

    fun updatePro(oldId:Int, nameOfitem: String,Rating: Int,realNum: Double,type:String, Item_img:String): Boolean {
        val cv = ContentValues()
        cv.put(DBModel.COL_NAME, nameOfitem)
        cv.put(DBModel.COL_Rating,Rating )
        cv.put(DBModel.COL_REALNUM,realNum )
        cv.put(DBModel.COL_TYPE, type)
        cv.put(DBModel.COL_IMAGE, Item_img)
       return db.update(DBModel.TABLE_NAME,cv,"${DBModel.COL_ID} = $oldId",null)>0
    }
    fun updatePro2(oldId:Int, nameOfitem: String,Rating: Int,realNum: Double): Boolean {
        val cv = ContentValues()
        cv.put(DBModel.COL_NAME, nameOfitem)
        cv.put(DBModel.COL_Rating,Rating )
        cv.put(DBModel.COL_REALNUM,realNum )
        return db.update(DBModel.TABLE_NAME,cv,"${DBModel.COL_ID} = $oldId",null)>0

    }

    fun updateName(oldId:Int, nameOfitem: String): Boolean {
        val cv = ContentValues()
        cv.put(DBModel.COL_NAME, nameOfitem)
        return db.update(DBModel.TABLE_NAME,cv,"${DBModel.COL_ID} = $oldId",null)>0
    }
    fun getResWoman():ArrayList<DBModel>{
        val data = ArrayList<DBModel>()
        val type="clothes"
        val v =
            db.rawQuery("select * from ${DBModel.TABLE_NAME}  where ${DBModel.COL_TYPE} = '$type'  order by ${DBModel.COL_ID} desc", null)
        v.moveToFirst()
        while (!v.isAfterLast) {
            val vv = DBModel(
                v.getInt(0),
                v.getString(1),
                v.getInt(2),
                v.getDouble(3),
                v.getString(4),
                v.getString(5)
            )
            data.add(vv)
            v.moveToNext()
        }
        v.close()
        return data
    }
    fun getResKids():ArrayList<DBModel>{
        val data = ArrayList<DBModel>()
        val type="electroinc"
        val b =
            db.rawQuery("select * from ${DBModel.TABLE_NAME}  where ${DBModel.COL_TYPE} = '$type'  order by ${DBModel.COL_ID} desc", null)
        b.moveToFirst()
        while (!b.isAfterLast) {
            val bb= DBModel(
                b.getInt(0),
                b.getString(1),
                b.getInt(2),
                b.getDouble(3),
                b.getString(4),
                b.getString(5)
            )
            data.add(bb)
            b.moveToNext()
        }
        b.close()
        return data
    }
    companion object {
        val DATABASE_NAME = "University2"
        val DATABASE_VERSION = 1

    }
}