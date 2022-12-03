package com.german.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val myViewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set RycyclerView Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val myAdapter = ItemAdapter(this, myViewModel.get())
        recyclerView.adapter = myAdapter
        recyclerView.setHasFixedSize(true)

        // Set LiveData - Observer
        val myObserver = Observer<Numbers> { newNumber ->
            myViewModel.add(newNumber)
            myAdapter.updateNumbersList()
            recyclerView.smoothScrollToPosition(myViewModel.count()-1);
        }
        myViewModel.currentNumber.observe(this,myObserver)

        // Get UI Events
        val btn = findViewById<Button>(R.id.btnGo)
        btn.setOnClickListener(){
            val range = 1..6
            val newNumber = Numbers(range.random())
            myViewModel.currentNumber.value = newNumber
        }
    }
}