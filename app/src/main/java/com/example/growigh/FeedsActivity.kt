package com.example.growigh

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growigh.RetrofitGet.apiService
import com.example.growigh.dataclass.Images
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedsActivity : AppCompatActivity() {


    private lateinit var button : ImageButton
    private lateinit var recyclerView: RecyclerView
    private var progressDialog: ProgressDialog? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)

        recyclerView = findViewById(R.id.recyclerview)
        button = findViewById(R.id.refresh)

        recyclerView.layoutManager = LinearLayoutManager(this)

        showprogressbar()
        fetchImages()

        button.setOnClickListener {
            showprogressbar()
            fetchImages()
        }


    }

    val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun fetchImages() {

//        val apiService = RetrofitGet.apiService
//        val call = apiService.getRandomImages(10,"9t7twSxr6VMUR0F4aOHHpHqtYytYJe-dkJ7smmAKld4")
//
//        call.


        coroutineScope.launch {
            try {
                val images = apiService.getRandomImages("9t7twSxr6VMUR0F4aOHHpHqtYytYJe-dkJ7smmAKld4")
                val adapter = ImageAdapter(images)
                recyclerView.adapter = adapter
                Log.d("api","worked")
                dismissprogressbar()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("api", e.printStackTrace().toString())
                dismissprogressbar()
            }
        }
    }

    private fun showprogressbar(){
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)
        progressDialog?.show()
    }
    private fun dismissprogressbar(){
        progressDialog?.dismiss()
    }
}





