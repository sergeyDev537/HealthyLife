package com.exlab.healthylife.utils.validators

import android.util.Patterns
import com.exlab.healthylife.utils.Constants

object EmailValidator {
    //fun isValidEmail(text: CharSequence?) = text?.matches(Regex(Constants.EMAIL_REGEX)) ?: false

    fun isValidEmail(text: CharSequence?) =
        text?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: false
}