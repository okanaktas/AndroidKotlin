package com.okanaktas.fragmentnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.okanaktas.fragmentnavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.fragment_second, container, false)
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }


    //onViewCreated oluşturup yazıyorum ki her şey oluşturulduktan sonra yazayım hata oluşmasın
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Bugra")
            Navigation.findNavController(it).navigate(action)
        }


    }

}