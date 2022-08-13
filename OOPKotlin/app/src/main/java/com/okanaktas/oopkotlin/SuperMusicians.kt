package com.okanaktas.oopkotlin

class SuperMusicians(name: String, instrument: String, age: Int) :
    Musicians(name, instrument, age) {

        fun sing(){
            println("nothing else matters")
        }
}