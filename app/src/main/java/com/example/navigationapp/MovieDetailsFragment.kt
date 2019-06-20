package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = MovieDetailsFragmentArgs.fromBundle(arguments!!).nameArg
        movie_name.text = name
        author.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_movie_details_to_author_fragment))
        reviews.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_movie_details_to_reviews_fragment))
        trailer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_movie_details_to_trailer_fragment))
    }

}