package com.pedromazza.agenda.telas.acesso

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pedromazza.agenda.R
import com.pedromazza.agenda.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaAcesso(
    navController: NavController
) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_pedro_mazza),
                contentDescription = "Logo da Escola Estadual Pedro Mazza"
            )
            Column {
                FilledTonalButton(
                    onClick = {
                        navController.navigate(Screen.PrimeiraTelaTurma.route)
                    },
                ) {
                    Text(text = stringResource(id = R.string.bt_estudante))
                }
                FilledTonalButton(
                    onClick = {

                    }
                ) {
                    Text(text = stringResource(id = R.string.bt_professor))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DefaultPreview() {
    TelaAcesso(rememberNavController())
}


