package com.company.DesignPatterns.Kotlin

import org.junit.Test

sealed class AuthorizationState

object Unauthorized : AuthorizationState()

class Authorized(val userName : String) : AuthorizationState()

class AuthorizationPresenter {
    private var state : AuthorizationState = Unauthorized

    val isAuthorized : Boolean
    get() = when (state) {
        is Authorized -> true
        is Unauthorized -> false
    }

    val userName : String
    get() = when (val state = this.state) {
        is Authorized -> state.userName
        is Unauthorized -> "UNKNOWN"
    }

    fun loginUser(userName: String) {
        state = Authorized(userName)
    }
    fun logOut(){
        state = Unauthorized
    }

    override fun toString(): String =
        "User $userName is logged in : $isAuthorized"
}

class StateTest {
    @Test
    fun testState() {
        val authorizationPresenter = AuthorizationPresenter()

        authorizationPresenter.loginUser("admin")
        println(authorizationPresenter)

        assert(authorizationPresenter.isAuthorized)
        assert(authorizationPresenter.userName == "admin")

        authorizationPresenter.logOut()
        println(authorizationPresenter)
        assert(authorizationPresenter.isAuthorized.not())
        assert(authorizationPresenter.userName == "UNKNOWN")
    }
}