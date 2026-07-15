package za.hendrikdelange.mycompletefitnesstracker.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.AuthViewModel


@Composable
fun RegisterScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    onRegistered: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    val loading by viewModel.loading.collectAsState()

    val errorMessage by viewModel.errorMessage.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "Create Account"
        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            }
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            }
        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        Button(
            enabled = !loading,
            onClick = {

                viewModel.register(
                    email,
                    password
                ) {

                    onRegistered()

                }

            }
        ) {

            Text(
                text = if (loading)
                    "Creating..."
                else
                    "Create Account"
            )

        }


        errorMessage?.let {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = it
            )

        }

    }

}