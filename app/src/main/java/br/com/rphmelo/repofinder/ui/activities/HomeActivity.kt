package br.com.rphmelo.repofinder.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.ui.fragments.HomeFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.setUpDagger()
        this.setUpFragment()
    }

    private fun setUpDagger(){
        AndroidInjection.inject(this)
    }

    fun setUpFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, HomeFragment(), null)
                .commit()
    }
}
