package com.example.android.gymondoautomationtest.pages

import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.espressopageobject.extensions.click
import com.atiurin.espressopageobject.extensions.isDisplayed
import com.example.android.gymondoautomationtest.R

class LoginPage : Page {
    val PASSWORD_HINT = "Enter password here"
    val EMAIL_HINT = "Enter e-mail here"

    constructor(action: LoginPage.() -> Unit) {
        validate()
        this.action()
    }

    constructor() {
        validate()
    }

    private val emailField = withId(R.id.editText)
    private val passwordField = withId(R.id.editText2)
    private val loginButton = withId(R.id.button)

    override fun validate() {
        emailField.isDisplayed()
        withHint(EMAIL_HINT).isDisplayed()
        passwordField.isDisplayed()
        withHint(PASSWORD_HINT).isDisplayed()
        loginButton.isDisplayed()
    }


    fun inputEmail(text: String) = apply {
        step("Input email $text") {
            inputInEditText(emailField, text)
        }

    }

    fun inputPassword(text: String) = apply {
        step("Input password $text") {
            inputInEditText(passwordField, text)
        }
    }

    fun tapLogin() {
        loginButton.click()

    }

}