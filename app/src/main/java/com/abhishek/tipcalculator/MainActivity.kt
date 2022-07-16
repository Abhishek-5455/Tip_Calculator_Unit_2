package com.abhishek.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhishek.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener { calculateTip() }
    }
    private fun calculateTip(){
        val cost = binding.costOfService.text.toString()

        val tipPercentage = when(binding.group.checkedRadioButtonId){
            R.id.amazing -> 0.20
            R.id.good-> 0.15
            R.id.ok -> 0.10
            else -> 0.05
        }

        var tipAmount = cost.toDouble() * tipPercentage

        if(binding.switchBtn.isChecked){
            tipAmount = ceil(tipAmount)
        }
        val formatTip = NumberFormat.getCurrencyInstance().format(tipAmount)

        binding.finalTip.text = getString(R.string.tip_amount , formatTip)
    }
}