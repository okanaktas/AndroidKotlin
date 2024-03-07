package com.okanaktas.coroutineforkotlinandroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    //withContext -> bir thread içerisinde iken başka bir thread e iş yaptırmaya yarar

    runBlocking {
        launch(Dispatchers.Default) {
            //Dolardan sonra ki ifade hazır olarak geliyor ve hangi thread üzerinde çalıştığımızı söylüyor
            println("Context: ${coroutineContext}")
            withContext(Dispatchers.IO) {
                ("Context: ${coroutineContext}")
            }
        }

        //Genel de bu yapıyı Dispatchers.IO ile başlattığımız ve Dispatchers.Main ile bitirdiğimiz örneklerde görürüz
    }


}