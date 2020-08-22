package com.hasankaya.retrofitornekcalisma.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hasankaya.retrofitornekcalisma.R
import com.hasankaya.retrofitornekcalisma.adapter.RecyclerViewAdapter
import com.hasankaya.retrofitornekcalisma.model.CryptoModel
import com.hasankaya.retrofitornekcalisma.service.CryptoAPI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {

    private val BASE_URL="https://api.nomics.com/v1/"
    private var cryptoModels: ArrayList<CryptoModel>?=null
    private var recyclerViewAdapter:RecyclerViewAdapter?=null

    private var compositeDisposable: CompositeDisposable?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        compositeDisposable= CompositeDisposable()

        //RecyclerView
        val layoutManager: RecyclerView.LayoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager =layoutManager

        loadData()
    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava kullanacağımızı retrofite belirttik
            .build().create(CryptoAPI::class.java)
                    //servisi de bu şekilde oluşturabiliriz.

            compositeDisposable?.add(retrofit.getData()
                .subscribeOn(Schedulers.io())//asenkron bir şekilde yapacağımız işlemler için kullanırız. Ancak veriyi de main threatte işleyeceğiz. //ARKA PLANDA DİNLEDİK
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse))//veriyi farklı bir threatte gözlemleyip ana threatte işlememize olanak sağlıyor.    //ÖN PLANDA İŞLEDİK
                                //BURADA ELE ALDIK



/*
  val service = retrofit.create(CryptoAPI::class.java)
  val call = service.getData()
        call.enqueue(object :Callback<List<CryptoModel>>{
            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
               t.printStackTrace()//loglarda hatayı gösterir
            }

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
               if(response.isSuccessful){
                   response.body()?.let {
                       //eğer bu null değilse şunları yap;
                       cryptoModels = ArrayList(it)

                      cryptoModels?.let {
                          recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
                          recyclerView.adapter= recyclerViewAdapter
                      }

                      for(cryptoModel : CryptoModel in cryptoModels!!){
                           println(cryptoModel.currency)
                           println(cryptoModel.price)
                       }

                   }
               }
            }

        })*/
    }

    private fun handleResponse(cryptoList:List<CryptoModel>){
        cryptoModels = ArrayList(cryptoList)

        cryptoModels?.let {
            recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
            recyclerView.adapter= recyclerViewAdapter
        }
    }

    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(applicationContext,"name: ${cryptoModel.currency}  price: ${cryptoModel.price}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}