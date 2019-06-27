package com.example.navigationapp

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash.*
import java.lang.Exception

class SplashFragment : Fragment(){

    lateinit var  handler: Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar!!.hide()
        handler = Handler()

//        val imageView = findViewById(R.id.splash_image)


//        splash()
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()
        splash()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)

    }

    fun splash(){

        context?.let {
            Glide.with(it)
                .load(R.drawable.we)
                .into(splash_image)
        }

        handler.postDelayed({
            //            Navigation.createNavigateOnClickListener(R.id.action_splash_fragment_to_movies_fragment)
            val action = SplashFragmentDirections.actionSplashFragmentToMoviesFragment()

            findNavController().navigate(action)

        }, 5000)
    }
}