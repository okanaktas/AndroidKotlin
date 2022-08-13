package com.okanaktas.oopkotlin

class Dog : Animal() {

    fun test(){
        super.sing() //super dediğimiz için bu sing animals içersindeki sing
    }

    override fun sing(){
        println("dog class")
    }

}