package com.example.explisitimplisitintent

import android.os.Parcel
import android.os.Parcelable

data class Nilai(
    val name: String?,
    val assignment: Double,
    val midterm: Double,
    val finalExam: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(assignment)
        parcel.writeDouble(midterm)
        parcel.writeDouble(finalExam)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Nilai> {
        override fun createFromParcel(parcel: Parcel): Nilai {
            return Nilai(parcel)
        }

        override fun newArray(size: Int): Array<Nilai?> {
            return arrayOfNulls(size)
        }
    }
}