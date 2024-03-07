package com.okanaktas.coroutineforkotlinandroid

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val downloadedName = async {
            downlaodName()
        }
        val downloadedAge = async {
            downloadAge()
        }

        println("${downloadedName.await()} ${downloadedAge.await()}")
    }


}

suspend fun downlaodName(): String {
    delay(2000)
    val userName = "Okan "
    println("User Name Download")
    return userName
}

suspend fun downloadAge(): Int {
    delay(4000)
    val userAge = 27
    println("User Age Download")
    return userAge
}