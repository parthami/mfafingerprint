package parth.mfa_fingerprint.interfaces

import android.text.Editable

/**
 * Created by Parth Chandratreya on 22/01/2018.
 */
interface  PasswordPresenterI {
    fun hashPassword(passwordToEncrypt: CharArray)
    fun savePassword(encryptedPassword: ByteArray, salt: ByteArray, iv: ByteArray)
    fun comparePassword(editable: Editable): Boolean
}