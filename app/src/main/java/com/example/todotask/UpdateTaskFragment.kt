package com.example.todotask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todotask.databinding.FragmentUpdateTaskBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.log


class UpdateTaskFragment : Fragment() {
    private lateinit var binding: FragmentUpdateTaskBinding
    private val args: UpdateTaskFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateTaskBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarIncludeUpdateLayout.toolbarTitle.text = "Update Task"
        binding.toolbarIncludeUpdateLayout.backButton.setOnClickListener {
            onBackPressed()
        }

        val todo = args.data


        binding.etUpdateName.setText(todo.name)
        binding.etUpdateDetails.setText(todo.details)
        binding.updateBtn.setOnClickListener {
            val name = binding.etUpdateName.text.toString()
            val details = binding.etUpdateDetails.text.toString()

            if (name.isBlank()) {
                Toast.makeText(requireContext(), "Please enter a name", Toast.LENGTH_SHORT).show()
            } else if (name.isDigitsOnly() || details.isDigitsOnly()) {
                Toast.makeText(
                    requireContext(),
                    "Name,Details must contain only letters",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (name.length < 3) {
                Toast.makeText(
                    requireContext(),
                    "Name must be at least 3 characters",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val time = getCurrentTime()
                val updatedTodo = Todo(id = todo.id, name = name, details = details, time = time)
                updateTask(updatedTodo)
                onBackPressed()
            }
        }
    }

    private fun updateTask(updatedTodo: Todo) {
        for (index in dataset.indices) {
            if (dataset[index].id == updatedTodo.id) {
                dataset[index] = updatedTodo
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