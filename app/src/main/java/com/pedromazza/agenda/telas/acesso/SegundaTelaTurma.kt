package com.pedromazza.agenda.telas.acesso

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pedromazza.agenda.R
import com.pedromazza.agenda.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegundaTelaTurma(
    navController: NavController,
    serie: Int
    ) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    when(serie) {
                        1 -> Text(text = stringResource(id = R.string.bt_turma1))
                        2 -> Text(text = stringResource(id = R.string.bt_turma2))
                        3 -> Text(text = stringResource(id = R.string.bt_turma3))
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar para a escolha da série"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.texto_tela2_turma),
                fontSize = 32.sp
            )
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.TelaPrincipal.turmaTelaPrincipal("$serie" + "A"))
                },
            ) {
                when(serie) {
                    1 -> Text(text = stringResource(id = R.string.bt_turma1_A))
                    2 -> Text(text = stringResource(id = R.string.bt_turma2_A))
                    3 -> Text(text = stringResource(id = R.string.bt_turma3_A))
                }
            }
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.TelaPrincipal.turmaTelaPrincipal("$serie" + "B"))
                },
            ) {
                when(serie) {
                    1 -> Text(text = stringResource(id = R.string.bt_turma1_B))
                    2 -> Text(text = stringResource(id = R.string.bt_turma2_B))
                    3 -> Text(text = stringResource(id = R.string.bt_turma3_B))
                }
            }
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.TelaPrincipal.turmaTelaPrincipal("$serie" + "C"))
                },
            ) {
                when(serie) {
                    1 -> Text(text = stringResource(id = R.string.bt_turma1_C))
                    2 -> Text(text = stringResource(id = R.string.bt_turma2_C))
                    3 -> Text(text = stringResource(id = R.string.bt_turma3_C))
                }
            }
            if(serie == 1) {
                FilledTonalButton(
                    onClick = {
                        navController.navigate(Screen.TelaPrincipal.turmaTelaPrincipal("1" + "D"))
                    },
                ) {
                    Text(text = stringResource(id = R.string.bt_turma1_D))
                }
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun DefaultPreview() {
    SegundaTelaTurma(rememberNavController(), 1)
}
