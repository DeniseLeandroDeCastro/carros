package br.com.denisecastro.carros.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.denisecastro.carros.R
import br.com.denisecastro.carros.enum.TipoCarro

class CarrosFragment : BaseFragment() {

    private var tipo: TipoCarro = TipoCarro.CLASSICOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tipo = arguments?.getSerializable("tipo") as TipoCarro
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_carros, container, false)
        val textView = view?.findViewById<TextView>(R.id.text)

        val tipoString = getString(tipo.string)
        textView?.text = "Carros $tipoString"
        return view
    }
}