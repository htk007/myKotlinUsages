package com.hekasoftdesign.framesexample.navigationkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hekasoftdesign.framesexample.R
import kotlinx.android.synthetic.main.fragment_my_second.*

class MySecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val myusername= MySecondFragmentArgs.fromBundle(it).username
            usernameTextView.text=myusername
        }

        buttonTwo.setOnClickListener {
            val actions = MySecondFragmentDirections.actionMySecondFragmentToMyFirstFragment()
            Navigation.findNavController(it).navigate(actions)
        }
    }

}