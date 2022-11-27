package com.rentreadychecklist.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rentreadychecklist.databinding.FragmentNavigationDrawerBinding


class NavigationDrawerFragment : Fragment() {

    private lateinit var viewBinding: FragmentNavigationDrawerBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentNavigationDrawerBinding.inflate(inflater, container, false)

        requireActivity().onBackPressedDispatcher.addCallback(
            (activity as AppCompatActivity),
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (isEnabled) {
                        isEnabled = false
                        if (viewBinding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                            viewBinding.drawerLayout.closeDrawer(GravityCompat.START)
                        }else{
                            requireActivity().onBackPressed()
                        }
                    }
                }
            }
        )

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.setSupportActionBar(viewBinding.toolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.show()

        navHostFragment = childFragmentManager.findFragmentById(com.rentreadychecklist.R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        val toggle = ActionBarDrawerToggle(
            activity, viewBinding.drawerLayout, viewBinding.toolbar, com.rentreadychecklist.R.string.app_name, com.rentreadychecklist.R.string.app_name
        )
        toggle.drawerArrowDrawable.color = Color.WHITE
        viewBinding.drawerLayout.setDrawerListener(toggle)
        toggle.syncState()
        viewBinding.navigationView.itemIconTintList = null

        setupWithNavController(viewBinding.navigationView, navController)
        viewBinding.navigationView.setupWithNavController(navController)


    }
}