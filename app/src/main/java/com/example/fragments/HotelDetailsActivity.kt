package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent

class HotelDetailsActivity : AppCompatActivity() {

    private val hotelId: Long by lazy {
        intent.getLongExtra(EXTRA_HOTEL_ID, -1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)
        if(savedInstanceState == null) {
            showHotelDetailsFragment()
        }
    }

    override fun getParentActivityIntent(): Intent? {
        val it = super.getParentActivityIntent()
        it?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return it
    }

    private fun showHotelDetailsFragment(){
        val fragment = HotelDetailsFragment.newInstance(hotelId)
        supportFragmentManager.beginTransaction().replace(R.id.details, fragment, HotelDetailsFragment.TAG_DETAILS).commit()
    }

    companion object {
        private const val EXTRA_HOTEL_ID = "hotel_id"

        fun open(context: Context, hotelId: Long) {
            context.startActivity(Intent(context, HotelDetailsActivity::class.java).apply {
                putExtra(EXTRA_HOTEL_ID, hotelId)
            })
        }
    }
}
