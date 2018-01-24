package parth.mfa_fingerprint.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_password.*
import parth.mfa_fingerprint.R
import parth.mfa_fingerprint.interactors.PasswordInteractor
import parth.mfa_fingerprint.interfaces.PasswordView
import parth.mfa_fingerprint.presenters.PasswordPresenter

class PasswordActivity : Activity(), PasswordView {

    val interactor = PasswordInteractor()
    var presenter = PasswordPresenter(this, interactor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
    }

    override fun checkClick(view: View) {
        // Hash the password
        presenter.hashPassword(passwordField.text)
        // Compare the password
        if(presenter.comparePassword()){
            Toast.makeText(this, "Password verified!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Password incorrect", Toast.LENGTH_LONG).show()
        }
    }

    override fun saveClick(view: View) {
        // Hash the password
        presenter.hashPassword(passwordField.text)
        // Save the password to the database
        presenter.savePassword()
        Toast.makeText(this, "Password saved!", Toast.LENGTH_LONG).show()

    }
}
