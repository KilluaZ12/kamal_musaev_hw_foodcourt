package com.example.kamal_musaev_hw_foodcourt

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Food (val title : String,
                     val image : Int,
                     val discount : Boolean,
                     val parts : Int,
                     val place : String,
                     val time : String,
                     val distance : String) : Parcelable