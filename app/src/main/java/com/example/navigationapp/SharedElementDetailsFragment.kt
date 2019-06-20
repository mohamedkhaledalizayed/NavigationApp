package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_shared_element_details.*

class SharedElementDetailsFragment  : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared_element_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        setHasOptionsMenu(true)
    }

    val IMAGE_URI = "https://i.scdn.co/image/8d5eabf813797aa39f6e8186f702a1998d12fe40"
    val HEADER_IMAGE_URI = "https://i.scdn.co/image/dbaf7f3e34a1fc0f3ec6ae165b467ad6739e0c59"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as AppCompatActivity
//        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //activity.setupActionBarWithNavController(findNavController())
        Glide.with(this).load(IMAGE_URI).into(imageView)
        Glide.with(this).load(HEADER_IMAGE_URI).into(headerImage)
    }

}