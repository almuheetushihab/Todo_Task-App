package com.example.todotask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todotask.databinding.FragmentUpdateTaskBinding
import viewModel.TodoViewModel
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

        val todo = args.data

        Log.d("Log404", "Got the todo$todo")


        binding.etUpdateName.setText(todo.name)
        binding.etUpdateDetails.setText(todo.details)
        binding.updateBtn.setOnClickListener {
            val name = binding.etUpdateName.text.toString()
            val details = binding.etUpdateDetails.text.toString()
            val time = getCurrentTime()
            val updatedTodo = Todo(id = todo.id, name = name, details = details, time = time)
            Log.d("Log404", "updateTask: $updatedTodo ")
            updateTask(updatedTodo)
            onBackPressed()
        }
    }

    private fun updateTask(updatedTodo: Todo) {
        for (i in dataset.indices) {
            if (dataset[i].id == updatedTodo.id) {
                Log.d("Log404", "Got it$dataset")
                dataset[i] = updatedTodo

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