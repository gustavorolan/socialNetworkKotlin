package com.api.socialNetwork.service.verifier.requestFriendshipVerfier.impl

import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.exception.AddingItselfException
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.verifier.requestFriendshipVerfier.RequestFriendshipVerifier
import org.springframework.stereotype.Service

@Service
class AddingItselfVerifierImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService
) : RequestFriendshipVerifier {
    override fun verify(request: Any) {
        val acceptFriendshipRequest = request as RequestFriendshipRequest
        if(findUserAuthenticatedService.user.id == acceptFriendshipRequest.friendId)
            throw AddingItselfException()
    }
}