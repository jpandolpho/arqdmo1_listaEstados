package br.edu.ifsp.dmo1.listaestados

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.listaestados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val states = arrayOf("AC","AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PR", "PI", "RJ", "RN", "RS", "RR", "SC", "SP", "SE", "TO")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //objeto encapsulador para a lista criada
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, states)
        //conectando a view com o encapsulador
        binding.listview.adapter = adapter

        binding.listview.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(
            this,
            "Você clicou em ${states.get(position)}",
            Toast.LENGTH_LONG
        ).show()
    }
}