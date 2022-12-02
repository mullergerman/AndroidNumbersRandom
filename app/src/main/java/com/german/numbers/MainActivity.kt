package com.german.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.german.numbers.adapter.ItemAdapter
import com.german.numbers.data.Datasource
import com.german.numbers.model.Numbers
import com.german.numbers.model.NumbersViewModel

class MainActivity : AppCompatActivity() {

    private val model: NumbersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get Dataset
        val myDataset = Datasource()

        // Set RycyclerView Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val myAdapter = ItemAdapter(this, myDataset.get())
        recyclerView.adapter = myAdapter
        recyclerView.setHasFixedSize(true)

        // Set LiveData - Observer
        val myObserver = Observer<Numbers> { newNumber ->
            myDataset.add(newNumber)
            myAdapter.updateNumbersList(newNumber)
            recyclerView.smoothScrollToPosition(myDataset.count()-1);
        }
        model.currentNumber.observe(this,myObserver)

        // Get UI Events
        val btn = findViewById<Button>(R.id.btnGo)
        btn.setOnClickListener(){
            val range = 1..6
            val newNumber = Numbers(range.random())
            model.currentNumber.value = newNumber
        }
    }
}