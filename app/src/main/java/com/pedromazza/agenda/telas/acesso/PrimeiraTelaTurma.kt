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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pedromazza.agenda.R
import com.pedromazza.agenda.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PrimeiraTelaTurma(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.bt_estudante))
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar para a tela inicial"
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
                text = stringResource(id = R.string.texto_tela1_turma),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.SegundaTelaTurma.serie(1))
                },
            ) {
                Text(text = stringResource(id = R.string.bt_turma1))
            }
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.SegundaTelaTurma.serie(2))
                },
            ) {
                Text(text = stringResource(id = R.string.bt_turma2))
            }
            FilledTonalButton(
                onClick = {
                    navController.navigate(Screen.SegundaTelaTurma.serie(3))
                },
            ) {
                Text(text = stringResource(id = R.string.bt_turma3))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DefaultPreview() {
    PrimeiraTelaTurma(rememberNavController())
}