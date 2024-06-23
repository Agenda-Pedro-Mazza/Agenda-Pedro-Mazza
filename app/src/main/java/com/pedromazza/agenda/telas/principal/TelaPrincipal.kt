package com.pedromazza.agenda.telas.principal

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pedromazza.agenda.navigation.Screen
import com.pedromazza.agenda.ui.NavigationDrawer

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaPrincipal(
    navController: NavController,
    turma: String
) {
    Scaffold (

    ){
        NavigationDrawer(navController, turma, Screen.TelaPrincipal.turmaTelaPrincipal(turma))
    }
}

@Preview (showSystemUi = true)
@Composable
private fun DefaultPreview() {
    TelaPrincipal(rememberNavController(), "1A")
}