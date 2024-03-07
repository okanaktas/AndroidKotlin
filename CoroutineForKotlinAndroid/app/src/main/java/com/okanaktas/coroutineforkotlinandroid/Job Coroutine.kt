package com.okanaktas.coroutineforkotlinandroid

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {


    runBlocking {
        val myJob = launch {
            delay(2000)
            println("Job")
            val myJob2 = launch {
                println("Job 2")
            }
        }

        //myJob bittiğinde ne yapılacağını yazıyoruz.
        myJob.invokeOnCompletion { println("my job ended") }

        //myJobın içine girmeden iptal etti
        myJob.cancel()


    }


}