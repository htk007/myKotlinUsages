package com.hasankaya.retrofitornekcalisma.adapter

import android.graphics.Color
import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasankaya.retrofitornekcalisma.R
import com.hasankaya.retrofitornekcalisma.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*

class RecyclerViewAdapter(private  val cyptoList: ArrayList<CryptoModel>, private val listener: Listener ) :RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>(){

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel){

        }
    }

    private val colors: Array<String> = arrayOf("#b61b1b","#1bb68b","#1b5cb6","#9d1bb6","#b5b61b","#1b54b6","#b61b32","#3fb61b","#571bb6")

    class RowHolder (view: View): RecyclerView.ViewHolder(view){
            fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener:Listener){
                //itemview, viewin kendisinden türetiliyor ve viewholderin içinde çıkıyor zaten
                itemView.setOnClickListener{
                    listener.onItemClick(cryptoModel)
                }
                itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
                itemView.text_name.text=cryptoModel.currency
                itemView.text_price.text=cryptoModel.price
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        //row layoutu burada bağlıyoruz.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {//kaç tane row oluşturacağımızı burada belirtiriz.
       return cyptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
       //hangi item ne verisi gösterecek onu göstereceğimiz yer.
            holder.bind(cyptoList[position],colors,position,listener )

    }
}