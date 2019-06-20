package com.example.navigationapp

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


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawerLayout?.closeDrawers()
        return true
    }

    lateinit var navHost: NavHostFragment
    lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        drawerLayout = findViewById(R.id.drawer_layout);

        var navigationView = findViewById<NavigationView>(R.id.navigationView)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController!!, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController!!)
        navigationView.setNavigationItemSelectedListener(this)

        // Get the NavController for your NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment)

        // Set up the ActionBar to stay in sync with the NavController
        setupActionBarWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val nd = findNavController(R.id.nav_host_fragment).currentDestination

        if (item.itemId == android.R.id.home) {
            if (nd?.label.toString().equals("movies_fragment")) {
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