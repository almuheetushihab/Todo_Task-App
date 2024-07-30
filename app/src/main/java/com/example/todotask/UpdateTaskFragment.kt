package com.example.todotask

import android.os.Bundle
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


class UpdateTaskFragment : Fragment() {
    private lateinit var binding: FragmentUpdateTaskBinding
    private val viewModel: TodoViewModel by viewModels()
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
        dataset.find {
            it.id == todo?.id
        }

//        todo = dataset.find { it.id == todo?.id }

        binding.etUpdateName.setText(todo?.name)
        binding.etUpdateDetails.setText(todo?.details)
        binding.updateBtn.setOnClickListener {

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