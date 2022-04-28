package com.felix.mvpexample

import android.text.TextUtils
import com.felix.mvpexample.model.Angka

class MainPresenterImp(private val view: MainView): MainPresenter {
    private val NUMBER = mutableListOf<Angka>()
    override fun addData(firstNum: Int, secondNum: Int) {
        if (TextUtils.isEmpty(firstNum.toString()) || TextUtils.isEmpty(secondNum.toString())){
            view.showMessage("Tidak boleh kosong")
        }else{
            NUMBER.run {
                val jumlah = firstNum+secondNum
                add(Angka(firstNum, secondNum, jumlah))
            }
            view.showMessage("data ditambahkan")
            view.clearField()
        }
    }

    override fun loadData() {
        if (NUMBER.size == 0){
            view.showMessage("data masih kosong")
        }else{
            var allData = ""

            for (i in 0 until NUMBER.size){
                    allData += "Angka Pertama : "+ NUMBER[i].firstNum + "\nNama Belakang : "+ NUMBER[i].secondNum + "\nJumlah : "+ NUMBER[i].jumlah+ "\n\n"
            }
            allData += "Total : " + NUMBER.size

            view.showData(allData)
        }
    }
}