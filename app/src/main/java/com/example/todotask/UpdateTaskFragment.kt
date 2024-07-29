package com.example.todotask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todotask.databinding.FragmentUpdateTaskBinding
import viewModel.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class UpdateTaskFragment : Fragment() {
    private lateinit var binding: FragmentUpdateTaskBinding
    private val viewModel: TodoViewModel by viewModels()


    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val todo = it.getSerializable("data") as Todo
            todo.name
            todo.details
            todo.time

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)


        binding.updateBtn.setOnClickListener {
            val name = binding.etUpdateName.text.toString()
            val details = binding.etUpdateDetails.text.toString()
            val time = getCurrentTime()
            val todo = Todo(name, details, time)
            dataset.add(todo)
            onBackPressed()
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