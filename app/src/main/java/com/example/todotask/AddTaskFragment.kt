package com.example.todotask

import SharedPrefHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.example.todotask.databinding.FragmentAddTaskBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class AddTaskFragment : Fragment() {
    private lateinit var binding: FragmentAddTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,

        ) {
        super.onViewCreated(view, savedInstanceState)
        binding.includeAddToolbarLayoutId.toolbarTitle.text = "Add Task"
        binding.includeAddToolbarLayoutId.backButton.setOnClickListener {
            onBackPressed()
        }

        binding.etName.getText()
        binding.etDetails.getText()


        binding.addBtn.setOnClickListener {
            val name = binding.etName.text.toString()
            val details = binding.etDetails.text.toString()

            if (name.isBlank()) {
                Toast.makeText(requireContext(), "Please enter a name", Toast.LENGTH_SHORT).show()
            } else if (name.length < 3) {
                Toast.makeText(
                    requireContext(),
                    "Name must be at least 3 characters",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!name.matches(Regex("^[a-zA-Z\\s]*$"))) {
                Toast.makeText(
                    requireContext(),
                    "Name must contain only letters",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val time = getCurrentTime()
                val todo = Todo(id = name, name = name, details = details, time = time)
                dataset.add(todo)
                onBackPressed()
            }
        }


    }

    private fun onBackPressed() {
        requireActivity().onBackPressed()

    }

    private fun getCurrentTime(): String {
        val currentTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return dateFormat.format(currentTime)

    }
}



