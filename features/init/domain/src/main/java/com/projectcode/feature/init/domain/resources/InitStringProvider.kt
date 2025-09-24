package com.projectcode.feature.init.domain.resources

import com.projectcode.moneymanager.essentials.resources.StringProvider

interface InitStringProvider: StringProvider {

   val deviceIsRootedErrorMessage: String

}