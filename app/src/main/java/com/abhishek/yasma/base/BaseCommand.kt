package com.abhishek.yasma.base

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import kotlin.reflect.KFunction0

sealed class BaseCommand {
    class UpdateAdapter(any: Any): BaseCommand()
    class ShowError(string: String): BaseCommand()

}