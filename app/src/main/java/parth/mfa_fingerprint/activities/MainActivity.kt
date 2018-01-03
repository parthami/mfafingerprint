package parth.mfa_fingerprint.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import parth.mfa_fingerprint.R
import parth.mfa_fingerprint.interfaces.MainView

class MainActivity : AppCompatActivity(), MainView {

    private val AUTHENTICATION_ONE_COMPLETED = 0
    private var auth1Completed = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth1Button.isEnabled = auth1Completed
    }

    override fun auth1Click(view: View) {
        val intent = Intent(this, FingerprintActivity::class.java)
        startActivityForResult(intent, AUTHENTICATION_ONE_COMPLETED)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == AUTHENTICATION_ONE_COMPLETED && resultCode == Activity.RESULT_OK) {
            val b = data.getBooleanExtra("success", false)
            auth1Button.isEnabled = b
        }
    }

}
