package com.projectcode.moneymanager

import android.content.Context
import com.projectcode.common_android.R
import com.projectcode.moneymanager.essentials.resources.EssentialsStringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class EssentialsStringProviderImpl @Inject constructor(
    @ApplicationContext private  val context: Context
): EssentialsStringProvider {

    override val unknownErrorMessage: String = context.getString(R.string.unknown_error_message)

}