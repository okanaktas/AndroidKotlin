package com.okanaktas.oopkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Constructor
        var myUser = User("okan", 26)

        println(myUser.name)
        println(myUser.age)
        println(myUser.information())

        var myMusicians = Musicians("Berkay", "Guitar", 15)
        myMusicians.age = 35
        println(myMusicians.age)
        // yazılamaz çünkü private set olarak tanımlı
        //myMusicians.name = "bugra"

        //Inheritance

        var okan = SuperMusicians("bugra","Bateri",30)
        okan.sing()

        //polymorphism

        //Static

        var mathematics = Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(2,3))
        println(mathematics.sum(1,6,8) )



        //Dynamic
        //farklı sınıflar ile yapınca dynamic diyoruz
//super ; kalıtım(inheritance) aldığımız sınıfa referans verir

        val animal = Animal()
        animal.sing()

        val cucka = Dog()
        cucka.test()
        cucka.sing()

        //abstract & interface (Soyut sınıf ve arayüz)


    }

}