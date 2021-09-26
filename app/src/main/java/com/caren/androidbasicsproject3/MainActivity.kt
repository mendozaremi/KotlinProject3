package com.caren.androidbasicsproject3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // function returns mutableList of task currently empty
    companion object {
        fun getTasks(): List<String> {
            val templateTasks = mutableListOf<String>()
            templateTasks.add("Pay Rent")
            templateTasks.add("Get haircut")
            templateTasks.add("Buy mom birthday present")
            templateTasks.add("Water plants")
            return templateTasks
        }
    }

    // variable to hold tasks in mutableList
    val tasks = mutableListOf<String>()

    // onCreate when app starts up setContentView to activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // variable to hold recyclerView find by id view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        tasks.addAll(getTasks()).toString()
        val adapter = TaskItemAdapter(tasks)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        // have the intention to open activity when clicked on task
//        findViewById<View>(R.id.task).setOnClickListener {
//
//            val taskDetail = findViewById<View>(R.id.task).toString()
//
//            Intent(this, EditTaskActivity::class.java).also {
//
//                startActivity(it)
//            }
//        }

        // set onClick listener to addTaskButton
        findViewById<View>(R.id.addTaskButton).setOnClickListener {

            // findViewById of edittextField where user types new task
            val taskEntryEditTextField = findViewById<EditText>(R.id.taskEntry)

            // store the text entry into a variable
            val newTask = taskEntryEditTextField.text.toString()

            // Clear the EditText field
            taskEntryEditTextField.text.clear()

            // add newTask to the mutableList task
            tasks.add(newTask)

            // notify the adapter of the change
            adapter.notifyItemChanged(tasks.size - 1)
        }
    }
}