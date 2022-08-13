package com.okanaktas.oopkotlin

class User : People {

    //property
    var name : String? = null
    var age : Int? = null

    //Constructer vs init

    constructor(nameInput : String , ageInput : Int){
        this.name = nameInput
        this.age = ageInput
    }

    init {
        println("INIT")
    }
}