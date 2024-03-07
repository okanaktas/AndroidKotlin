package com.okanaktas.retrofitkotlin.service

import com.okanaktas.retrofitkotlin.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    //GET -> Genelde veri çekmek için
    //POST -> Veriyi yazmak, değiştirmek için
    //UPDATE -> Veriyi güncellemek için
    //DELETE -> Veriyi silmek için

//https://raw.githubusercontent.com/
    // atilsamancioglu/K21-JSONDataSet/master/crypto.json

    //"ilk adresin baz kısmından sonrasını yazıyoruz"
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")

    //Bir fonk tanımlıyoruz. Bu fonksiyon sonucundan bize ne gelecek ne işlemi yapacağız onu belirlememiz gerkiyor.

            /*Kısaca bir get işlemi yap yukarıda ki işlemden. Bu get işleminde bir getData diye
    bir fonksiyon tanımlıyorum. Bu getData çağrıldığında bir call yapılacak ve
    geri dönen şey CryptoModel olacak ve Liste halinde gelecek.
     */
    fun getData(): Call<List<CryptoModel>>
}