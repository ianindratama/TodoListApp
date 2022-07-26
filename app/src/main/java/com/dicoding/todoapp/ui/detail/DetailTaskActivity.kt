package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val taskID = intent.getIntExtra(TASK_ID, 0)

        val title = findViewById<TextInputEditText>(R.id.detail_ed_title)
        val description = findViewById<TextInputEditText>(R.id.detail_ed_description)
        val dueDate = findViewById<TextInputEditText>(R.id.detail_ed_due_date)
        val deleteBtn = findViewById<Button>(R.id.btn_delete_task)

        val factory = ViewModelFactory.getInstance(this)
        val detailViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)

        detailViewModel.setTaskId(taskID)

        detailViewModel.task.observe(this){

            title.setText(it.title)
            description.setText(it.description)
            dueDate.setText(DateConverter.convertMillisToString(it.dueDateMillis))

            deleteBtn.setOnClickListener {
                detailViewModel.deleteTask()
                detailViewModel.task.removeObservers(this)
                finish()
            }

        }


    }
}