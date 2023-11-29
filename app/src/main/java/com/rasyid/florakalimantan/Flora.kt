package com.rasyid.florakalimantan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flora(
    val name: String,
    val desc: String,
    val photo: Int
) : Parcelable
