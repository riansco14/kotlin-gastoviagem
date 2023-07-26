package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //o binding serve pra pegar automaticamente os componentes com id do XML

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // o layoutInflater vem da classe do AppCompatActivity
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //adicionar evento de clique
        binding.buttonCalculate.setOnClickListener(this)

        /*
            Uma forma de fazer o evento de click
            binding.buttonCalculate.setOnClickListener(object : View.OnClickListener{
                 override fun onClick(p0: View?) {

                 }

             })
         */


    }

    private fun isValid(): Boolean{
        if(binding.editDistance.text.toString() != ""
            && binding.editPrice.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString().toFloat() != 0f){
            return true
        }

        return false
    }

    private fun calculate() {


        if(isValid()){
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            val totalValueStr = "R$ %.2f".format(totalValue)
            println(totalValue)

            binding.textTotalValue.setText(totalValueStr)
        }

        else{
            // Mostrar uma mensagem quando clicado
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }
}