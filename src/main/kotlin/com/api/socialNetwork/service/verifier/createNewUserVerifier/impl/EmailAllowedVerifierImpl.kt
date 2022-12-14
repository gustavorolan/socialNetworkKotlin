package com.api.socialNetwork.service.verifier.createNewUserVerifier.impl

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.exception.EmailNotAllowedException
import com.api.socialNetwork.service.verifier.createNewUserVerifier.CreateNewUserVerifier
import org.springframework.stereotype.Component
import java.util.regex.Pattern

@Component
class EmailAllowedVerifierImpl : CreateNewUserVerifier {
    override fun verify(request: Any) {
        val requestMap: CreateNewUserRequest = request as CreateNewUserRequest
        val patternEmail = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE
        )
        val matcher = patternEmail.matcher(requestMap.email)
        if (!matcher.find()) {
            throw EmailNotAllowedException()
        }
    }
}