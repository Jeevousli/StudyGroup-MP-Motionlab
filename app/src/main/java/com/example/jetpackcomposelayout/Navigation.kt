package com.example.jetpackcomposelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.jetpackcomposelayout.ui.theme.JetpackComposeLayoutTheme
import com.example.jetpackcomposelayout.ui.theme.login.LoginScreen
import com.example.jetpackcomposelayout.ui.theme.signup.SignUpScreen
import com.example.jetpackcomposelayout.ui.theme.signup.PolicyScreen
import com.example.jetpackcomposelayout.ui.theme.signup.PrivacyScreen
import com.example.jetpackcomposelayout.ui.theme.HomeScreen

@Composable
fun MyNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Route.LoginScreen().name, modifier = modifier) {
        composable(route = Route.LoginScreen().name) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Route.HomeScreen().name) {
                        popUpTo(Route.LoginScreen().name) { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate(Route.SignUpScreen().name) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(route = Route.SignUpScreen().name) {
            SignUpScreen(
                onSignUpClick = {
                    navController.navigate(Route.HomeScreen().name) {
                        popUpTo(Route.LoginScreen().name) { inclusive = true }
                    }
                },
                onLoginClick = {
                    navController.navigate(Route.LoginScreen().name) {
                        launchSingleTop = true
                    }
                },
                onPrivacyClick = {
                    navController.navigate(Route.PrivacyScreen().name) {
                        launchSingleTop = true
                    }
                },
                onPolicyClick = {
                    navController.navigate(Route.PolicyScreen().name) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(route = Route.PolicyScreen().name) {
            PolicyScreen {
                navController.navigateUp()
            }
        }
        composable(route = Route.PrivacyScreen().name) {
            PrivacyScreen {
                navController.navigateUp()
            }
        }
        composable(route = Route.HomeScreen().name) {
            HomeScreen()
        }
    }
}

sealed class Route {
    data class LoginScreen(val name: String = "Login") : Route()
    data class SignUpScreen(val name: String = "Sign Up") : Route()
    data class PrivacyScreen(val name: String = "Privacy") : Route()
    data class PolicyScreen(val name: String = "Policy") : Route()
    data class HomeScreen(val name: String = "Home Screen") : Route()
}
