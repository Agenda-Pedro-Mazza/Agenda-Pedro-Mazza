package com.pedromazza.agenda.telas.principal

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pedromazza.agenda.navigation.Screen
import com.pedromazza.agenda.ui.NavigationDrawer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaTarefas(
    navController: NavController,
    turma: String
) {
    Scaffold {
        NavigationDrawer(navController = navController, turma = turma, Screen.TelaPrincipal.turmaTarefas(turma))

    }
}