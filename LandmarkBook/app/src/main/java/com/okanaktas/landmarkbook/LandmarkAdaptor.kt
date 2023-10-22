package com.okanaktas.landmarkbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okanaktas.landmarkbook.databinding.RecylerRowBinding

class LandmarkAdaptor(val landmarkList: ArrayList<Landmark>) :
    RecyclerView.Adapter<LandmarkAdaptor.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecylerRowBinding) : RecyclerView.ViewHolder(binding.root)

    //android View Holder ilk oluşturulduğunda ne olacak
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecylerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    //Kaç tane oluşturacağımız kısım
    override fun getItemCount(): Int {
        return landmarkList.size
    }

    //Bağlandıktan sonra ne olacağı, hangi textde hangi veri kullanılacak
    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recylerViewTextView.text = landmarkList.get(position).name
    }
}