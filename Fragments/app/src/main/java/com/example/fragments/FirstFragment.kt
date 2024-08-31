package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fragments.FirstFragmentDirections
import com.example.fragments.SecondFragmentArgs
import com.example.fragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLinester()

        listenerFragment()
    }

    private fun initLinester() {
        val name = "Murillo Ribeiro"

        binding.btnNext.setOnClickListener {
            val action = FirstFragmentDirections
                .actionFirstFragmentToSecondFragment(name)
            findNavController().navigate(action)
        }
    }

    private fun listenerFragment() {
        parentFragmentManager.setFragmentResultListener(
            "KEY",
            this
        ) { key, bundle ->
            val name = bundle[key].toString()
            Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}