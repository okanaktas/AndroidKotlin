package com.okanaktas.landmarkbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okanaktas.landmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarklist: ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    //recycler view ilk oluşturulduğunda ne olacak ? layout ile bağlama işlemini yapıyoruz.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    //kaç tane oluşturacağız bundan. mesela şuan 4 tane. internetten indirmiş olsaydık bilmeyeceğimiz için burada arraylisiti burada isteyeceğiz
    override fun getItemCount(): Int {
        return landmarklist.size
    }

    //bağlandıktan sonra ne olacak. hangi texte hangi veri kullanılacak
    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarklist.get(position).name
    }
}