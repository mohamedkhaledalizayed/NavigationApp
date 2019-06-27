package com.example.navigationapp

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.opengl.ETC1.getHeight
import android.widget.RelativeLayout
import android.opengl.ETC1.getWidth
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.ViewCompat.setX




class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawerLayout?.closeDrawers()

        var id = item.itemId

        when (id) {
            R.id.first -> navController.navigate(R.id.android_fragment)
            R.id.second -> navController.navigate(R.id.doller_fragment)
            R.id.third -> navController.navigate(R.id.save_fragment)
        }
        return true
    }

    lateinit var navHost: NavHostFragment
    lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private val END_SCALE = 0.8f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        drawerLayout = findViewById(R.id.drawer_layout)

        var navigationView = findViewById<NavigationView>(R.id.navigationView)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController!!, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController!!)
        navigationView.setNavigationItemSelectedListener(this)

        // Get the NavController for your NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment)

        // Set up the ActionBar to stay in sync with the NavController
        setupActionBarWithNavController(navController)

        ///


        var contentView = findViewById<View>(R.id.holder)
        drawerLayout.setScrimColor(Color.TRANSPARENT)
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
           override fun onDrawerSlide(drawer: View, slideOffset: Float) {

               // Scale the View based on current slide offset
               var diffScaledOffset = slideOffset * (1 - END_SCALE)
               var offsetScale = 1 - diffScaledOffset
               contentView.scaleX = offsetScale
               contentView.scaleY = offsetScale

               // Translate the View, accounting for the scaled width
               var xOffset = drawer.width  * slideOffset
               var xOffsetDiff = contentView.width * diffScaledOffset / 2
               var xTranslation = (xOffset - xOffsetDiff )
               contentView.translationX = xTranslation
               Log.e("ll",xTranslation.toString())
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                   contentView.elevation = 25f
                   drawer.elevation = 0f
               }

           }

            override fun onDrawerClosed(drawerView: View) {}
        }
        )

        ///
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navDestination = findNavController(R.id.nav_host_fragment).currentDestination

//        navHost.navController.navigateUp()

        if (item.itemId == android.R.id.home) {
            if (navDestination?.label.toString().equals("movies_fragment")) {
                drawerLayout?.openDrawer(GravityCompat.START)
            } else {
                navHost.navController.navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START)!!) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }
}