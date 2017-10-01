package com.laboratory.android.fistkotlinapplication

import java.io.Serializable

/**
 * Created by Susiane on 30/09/2017.
 */

data class Person(var name : String, var age: Int) : Serializable{
    override fun toString(): String {
        return "$name - $age"
    }
}