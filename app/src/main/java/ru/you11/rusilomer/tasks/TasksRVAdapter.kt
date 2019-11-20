package ru.you11.rusilomer.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.you11.rusilomer.databinding.ItemTaskBinding
import ru.you11.rusilomer.model.Task

class TasksRVAdapter(val onTaskClick: (points: Int) -> Unit): RecyclerView.Adapter<TaskViewHolder>() {

    private val data = ArrayList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater)
        return TaskViewHolder(binding, onTaskClick)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun updateData(newData: ArrayList<Task>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}