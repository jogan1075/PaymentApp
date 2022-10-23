package com.jmc.payment

import com.jmc.payment.data.remote.models.*
import com.jmc.utils.RandomFactory


object TestFactory {

    fun makePaymentList(count: Int) =
        (0..count).map { makeNewPayment() }

    private fun makeNewPayment(): NewPayment {
        return NewPayment(
            id = RandomFactory.generateString(),
            name = RandomFactory.generateString(),
            payment_type_id = RandomFactory.generateString(),
            status = RandomFactory.generateString(),
            secure_thumbnail = RandomFactory.generateString(),
            thumbnail = RandomFactory.generateString(),
            deferred_capture = RandomFactory.generateString(),
            settings = makeSettingList(1),
            additional_info_needed = RandomFactory.generateArrayString(),
            min_allowed_amount = RandomFactory.generateInt(),
            max_allowed_amount = RandomFactory.generateInt(),
            accreditation_time = RandomFactory.generateInt(),
            financial_institutions = RandomFactory.generateArrayString(),
            processing_modes = RandomFactory.generateArrayString(),
        )
    }


    private fun makeSettingList(count: Int) =
        (0..count).map { makeSettings() }


    private fun makeSettings(): Settings {
        return Settings(
            card_number = makeCardNumber(),
            bin = makeBin(),
            security_code = makeSecurityCode(),
        )
    }

    private fun makeCardNumber(): CardNumber {
        return CardNumber(
            validation = RandomFactory.generateString(),
            length = RandomFactory.generateInt()
        )
    }

    private fun makeBin(): Bin {
        return Bin(
            pattern = RandomFactory.generateString(),
            installments_pattern = RandomFactory.generateString(),
            exclusion_pattern = RandomFactory.generateString(),
        )
    }

    private fun makeSecurityCode(): SecurityCode {
        return SecurityCode(
            length = RandomFactory.generateInt(),
            card_location = RandomFactory.generateString(),
            mode = RandomFactory.generateString(),
        )
    }
    

}
