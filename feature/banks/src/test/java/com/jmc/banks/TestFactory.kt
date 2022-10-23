package com.jmc.banks

import com.jmc.banks.data.remote.model.CardIssuer
import com.jmc.utils.RandomFactory


object TestFactory {

    fun makeCardIssuerList(count: Int) =
        (0..count).map { makeCardIssuer() }

    private fun makeCardIssuer(): CardIssuer {
        return CardIssuer(
            id = RandomFactory.generateString(),
            name = RandomFactory.generateString(),
            secureThumbnail = RandomFactory.generateString(),
            thumbnail = RandomFactory.generateString(),
            merchantAccountId = RandomFactory.generateString(),
            processingMode = RandomFactory.generateString(),

            )
    }




}
