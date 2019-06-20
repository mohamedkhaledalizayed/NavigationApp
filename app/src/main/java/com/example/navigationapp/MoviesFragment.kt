package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_movies.*
import androidx.appcompat.app.AppCompatActivity



class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared_element_transition.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_movies_fragment_to_fragment_shared_element_transition))

        (activity as AppCompatActivity).supportActionBar!!.show()

        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

        movie_1.setOnClickListener {
            val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDatails()
            action.nameArg = "Movie 111111"
            findNavController().navigate(action)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Toast.makeText(context,"hhhhhhhhh",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}