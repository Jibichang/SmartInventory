package org.lox.smartinventory.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.NavigationUI
import org.lox.smartinventory.databinding.ActivityMainBinding
import androidx.navigation.*
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.lox.smartinventory.R


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        @Suppress("UNUSED_VARIABLE")
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        bottomNavView = binding.bottomNavigationView

        navController = this.findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
        bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
//                bottomNavView.isItemHorizontalTranslationEnabled = false

            }
        }
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.bottomNavigationView).navigateUp()

    private fun AppCompatActivity.setupActionBarWithNavController(
        navController: NavController,
        drawerLayout: DrawerLayout? = null
    ) { NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout) }

}
