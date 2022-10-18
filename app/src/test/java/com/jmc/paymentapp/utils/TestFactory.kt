package com.jmc.paymentapp.utils

import com.google.gson.annotations.SerializedName
import com.jmc.paymentapp.features.banks.data.remote.model.CardIssuer
import com.jmc.paymentapp.features.installments.data.remote.model.InstallmentOption
import com.jmc.paymentapp.features.installments.data.remote.model.Issuer
import com.jmc.paymentapp.features.installments.data.remote.model.PayerCost
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI
import com.jmc.paymentapp.features.payment.data.remote.models.*
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


    fun makeInstallmentOptionList(count: Int) =
        (0..count).map { makeInstallmentOption() }

    private fun makeInstallmentOption(): InstallmentOption {
        return InstallmentOption(
            agreements = RandomFactory.generateString(),
            issuer = makeIssuer(),
            merchantAccountId = RandomFactory.generateString(),
            payerCosts = makePayerCostList(1),
            paymentMethodId = RandomFactory.generateString(),
            paymentTypeId = RandomFactory.generateString(),
            processingMode = RandomFactory.generateString(),
        )
    }

    private fun makePayerCostList(count: Int) =
        (0..count).map { makePayerCost() }


    private fun makePayerCost(): PayerCost {
        return PayerCost(
            discountRate = RandomFactory.generateFloat(),
            installmentAmount = RandomFactory.generateFloat(),
            installmentRate = RandomFactory.generateFloat(),
            installmentRateCollector = RandomFactory.generateArrayString(),
            installments = RandomFactory.generateInt(),
            labels = RandomFactory.generateArrayString(),
            maxAllowedAmount = RandomFactory.generateFloat(),
            minAllowedAmount = RandomFactory.generateFloat(),
            paymentMethodOptionId = RandomFactory.generateString(),
            recommendedMessage = RandomFactory.generateString(),
            reimbursementRate = RandomFactory.generateString(),
            totalAmount = RandomFactory.generateFloat(),
        )
    }

    private fun makeIssuer(): Issuer {
        return Issuer(
            id = RandomFactory.generateString(),
            name = RandomFactory.generateString(),
            secureThumbnail = RandomFactory.generateString(),
            thumbnail = RandomFactory.generateString(),
        )
    }
    fun makePayerCostUIList(count: Int) =
        (0..count).map { makePayerCostUI() }


    private fun makePayerCostUI(): PayerCostUI {
        return PayerCostUI(
            paymentMethodOptionId = RandomFactory.generateString(),
            recommendedMessage = RandomFactory.generateString(),

        )
    }

}
