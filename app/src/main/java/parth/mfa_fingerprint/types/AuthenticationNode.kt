package parth.mfa_fingerprint.types

/**
 * Created by Parth Chandratreya on 12/01/2018.
 */
enum class AuthenticationNode(val label: String ) {
    FINGERPRINT("Fingerprint"),
    KEYSTROKE("Keyboard")
}