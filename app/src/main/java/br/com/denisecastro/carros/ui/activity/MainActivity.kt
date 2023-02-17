package br.com.denisecastro.carros.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import br.com.denisecastro.carros.R
import br.com.denisecastro.carros.enum.TipoCarro
import br.com.denisecastro.carros.extensions.setupToolbar
import br.com.denisecastro.carros.extensions.toast
import com.google.android.material.navigation.NavigationView

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
        setupNavDrawer()
    }

    private fun setupNavDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle (
            this, drawer, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_carros_todos -> {
                toast("Clicou em carros")
            }
            R.id.nav_item_carros_classicos -> {
                val intent = Intent(context, CarrosActivity::class.java)
                intent.putExtra("tipo", TipoCarro.CLASSICOS)
                startActivity(intent)
            }
            R.id.nav_item_carros_esportivos -> {
                val intent = Intent(context, CarrosActivity::class.java)
                intent.putExtra("tipo", TipoCarro.ESPORTIVOS)
                startActivity(intent)
            }
            R.id.nav_item_carros_luxo -> {
                val intent = Intent(context, CarrosActivity::class.java)
                intent.putExtra("tipo", TipoCarro.LUXO)
                startActivity(intent)
            }
            R.id.nav_item_site_carro -> {
                toast("Clicou em site do carro")
            }
            R.id.nav_item_settings -> {
                toast("Clicou em configurações")
            }
        }
        return true
    }
}