package com.example.todotask

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.todotask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnAdd: ImageButton


    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.todoTask_Fragment_nav_id) {
                binding.btnAdd.visibility = View.VISIBLE
            } else {
                binding.btnAdd.visibility = View.GONE
            }
        }


        btnAdd = binding.btnAdd
        btnAdd.setOnClickListener {
            navController.navigate(R.id.action_todoTask_Fragment_nav_id_to_addTask_Fragment_nav_id)
        }
    }

}

