package ru.you11.rusilomer

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class TasksFragment: Fragment() {

    lateinit var viewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    private fun createViewModel(): TasksViewModel {
        return ViewModelProviders.of(this).get(TasksViewModel::class.java)
    }
}