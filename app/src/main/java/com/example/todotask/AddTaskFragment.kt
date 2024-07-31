package com.example.todotask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todotask.databinding.FragmentAddTaskBinding
import viewModel.TodoViewModel
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

        binding.etName.getText()
        binding.etDetails.getText()


        binding.addBtn.setOnClickListener {
            val name = binding.etName.text.toString()
            val details = binding.etDetails.text.toString()
            val time = getCurrentTime()
            val id = (0..100).random()
            val todo = Todo(id = id.toString(), name = name, details = details, time = time)
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



