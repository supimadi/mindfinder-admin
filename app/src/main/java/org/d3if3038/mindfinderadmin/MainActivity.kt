package org.d3if3038.mindfinderadmin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if3038.mindfinderadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.main_container)
//        NavigationUI.setupActionBarWithNavController(this, navController)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_main_home -> {
                    navController.navigate(R.id.welcomeFragment)
                    true
                }
                R.id.menu_main_result -> {
                    navController.navigate(R.id.historyFragment)
                    true
                }
                R.id.menu_main_setting -> {
                    navController.navigate(R.id.settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//    }
}