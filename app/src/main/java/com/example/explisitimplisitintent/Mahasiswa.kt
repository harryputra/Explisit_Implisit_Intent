package com.example.explisitimplisitintent

import android.os.Parcel
import android.os.Parcelable

data class Mahasiswa(
    val name: String,
    val address: String,
    val phoneNumber: String,
    val birthDate: String,
    val gender: String,
    val department: String,
    val hobbies: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: mutableListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(phoneNumber)
        parcel.writeString(birthDate)
        parcel.writeString(gender)
        parcel.writeString(department)
        parcel.writeStringList(hobbies)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mahasiswa> {
        override fun createFromParcel(parcel: Parcel): Mahasiswa {
            return Mahasiswa(parcel)
        }

        override fun newArray(size: Int): Array<Mahasiswa?> {
            return arrayOfNulls(size)
        }
    }
}
