package com.example.core.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

fun String.getEmptyStateValue(emptyValue: String = "-"): String = this.ifEmpty { emptyValue }

fun String.safeToInt() : Int {
    return try {
        this.toInt()
    }catch (e: Exception) {
        NULL_NUMBER
    }
}

fun String.safeToDouble() : Double {
    return try {
        this.toDouble()
    }catch (e: Exception) {
        NULL_NUMBER_DOUBLE
    }
}

fun String.safeToFloat() : Float {
    return try {
        this.toFloat()
    }catch (e: Exception) {
        NULL_NUMBER_FLOAT
    }
}

fun <T> Collection<T>.whenNotEmpty(): Collection<T>? = ifEmpty { null }

fun Int?.orDefault(defaultValue: Int = NULL_NUMBER): Int = this ?: defaultValue

fun Boolean?.orDefault(defaultValue: Boolean = false): Boolean = this ?: defaultValue

fun Double?.orDefault(defaultValue: Double = NULL_NUMBER_DOUBLE): Double = this ?: defaultValue

fun Long?.orDefault(defaultValue: Long = NULL_NUMBER.toLong()): Long = this ?: defaultValue

fun <T> MutableList<T>.isLastItem(item: T): Boolean {
    return this.indexOf(item) == this.lastIndex
}

inline fun <reified T> String.toListOrEmpty(): List<T> {
    if (this.isBlank()) return emptyList()

    val type: Type = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson<List<T>>(this, type) ?: emptyList()
}