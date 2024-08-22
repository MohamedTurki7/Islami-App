package com.route.appislami.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.appislami.R
import com.route.appislami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    var counter = 0
    var currentIndex = 0
    lateinit var azkarList: MutableList<String>
    lateinit var binding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbehBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.tvTasbehNameCounter.text = azkarList[0]


        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.sebhaBody.setOnClickListener {
            binding.sebhaBody.rotation = (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.tvTasbehNameCounter.text = azkarList[currentIndex]

            }
            binding.tvTasbehNumbersCounter.text = counter.toString()
        }

    }
}