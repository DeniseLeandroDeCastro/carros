package br.com.denisecastro.carros.ui.activity

import android.os.Bundle
import br.com.denisecastro.carros.R
import br.com.denisecastro.carros.enum.TipoCarro
import br.com.denisecastro.carros.extensions.addFragment
import br.com.denisecastro.carros.extensions.setupToolbar
import br.com.denisecastro.carros.ui.fragments.CarrosFragment

class CarrosActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        val tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.string)

        setupToolbar(R.id.toolbar, title, true)

        if (savedInstanceState == null) {
            addFragment(R.id.container, CarrosFragment())
        }
    }
}