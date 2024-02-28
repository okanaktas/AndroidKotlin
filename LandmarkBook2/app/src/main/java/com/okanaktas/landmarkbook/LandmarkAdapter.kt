package com.okanaktas.landmarkbook

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LandmarkAdapter : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    //recycler view ilk oluşturulduğunda ne olacak ? layout ile bağlama işlemini yapıyoruz.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        TODO("Not yet implemented")
    }
    //kaç tane oluşturacağız bundan. mesela şuan 4 tane. internetten indirmiş olsaydık bilmeyeceğimiz için burada arraylisiti burada isteyeceğiz
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    //bağlandıktan sonra ne olacak. hangi texte hangi veri kullanılacak
    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        TODO("Not yet implemented")
    }
}