package com.felix.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.felix.mvpexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenterImp: MainPresenterImp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = MainPresenterImp(this)

        binding.btnSubmit.setOnClickListener {
            presenterImp.addData(
                binding.etAngka.text.toString().toInt(),
                binding.etAngka2.text.toString().toInt()
            )
        }

        binding.btnShow.setOnClickListener {
            presenterImp.loadData()
        }
    }
    override fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(data: String) {
        AlertDialog
            .Builder(this)
            .setNegativeButton("Close"){dialog,_ -> dialog.dismiss()
            }
            .setTitle("List")
            .setMessage(data)
            .create()
            .show()
    }

    override fun clearField() {
        binding.etAngka.text!!.clear()
        binding.etAngka2.text!!.clear()
    }
}