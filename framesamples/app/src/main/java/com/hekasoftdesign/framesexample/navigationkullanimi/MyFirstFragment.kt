package com.hekasoftdesign.framesexample.navigationkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hekasoftdesign.framesexample.R
import kotlinx.android.synthetic.main.fragment_my_first.*

class MyFirstFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonOne.setOnClickListener {
          val actions= MyFirstFragmentDirections.actionMyFirstFragmentToMySecondFragment("KAYA")
          Navigation.findNavController(it).navigate(actions)
        }
    }

}