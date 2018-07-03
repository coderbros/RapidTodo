package com.todo.rapidtodo

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.content_main.*


class ToDoAdapter(val context: Context, val todos: List<String> = emptyList<String>()): RecyclerView.Adapter<ToDoItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemHolder {
        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.todo_cell, parent, false)
        return ToDoItemHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.count()
    }

    override fun onBindViewHolder(holder: ToDoItemHolder, position: Int) {
        holder.todoTextView.text = todos.get(position)
    }
}

class ToDoItemHolder(val view: View): RecyclerView.ViewHolder(view) {
    val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    val todoTextView: TextView = view.findViewById(R.id.todoTextView)
}


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupAddTodoButton()
        setupTodoList()
    }

    private fun setupAddTodoButton() {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { addTodo() }
    }

    private fun addTodo() {

    }

    private fun getData(): List<String> {
        return listOf("Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", "This", "is" ,"Akshay")
    }
    private fun setupTodoList() {
        todosView.adapter = ToDoAdapter(this, getData())
        todosView.layoutManager = LinearLayoutManager(this)
    }
}
