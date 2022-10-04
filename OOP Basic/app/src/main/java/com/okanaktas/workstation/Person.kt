package com.okanaktas.workstation

open class Person(name: String, surName: String, age: Int) {

    var name: String? = name
        private set
        get
    var surName: String? = surName
        private set
        get
    var age: Int? = age
        private set
        get

}