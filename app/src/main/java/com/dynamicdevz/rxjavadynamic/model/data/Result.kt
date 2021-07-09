package com.dynamicdevz.rxjavadynamic.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize ///must add plugin 'kotlin-android-extensions'
data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable