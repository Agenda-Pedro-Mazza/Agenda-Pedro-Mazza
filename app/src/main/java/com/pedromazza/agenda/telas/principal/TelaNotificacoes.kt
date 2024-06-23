package com.pedromazza.agenda.telas.principal

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import com.pedromazza.agenda.notifications.TarefaNotificationService
import com.pedromazza.agenda.ui.NavigationDrawer
import com.pedromazza.agenda.ui.theme.AgendaEscolaTheme

class TelaNotificacoes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = TarefaNotificationService(applicationContext)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaNotificacoes(
    navController: NavController,
    turma: String
) {
    Scaffold {
        NavigationDrawer(navController = navController, turma = turma, route = Screen.Notificacoes.turmaNotificacoes(turma))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun DefaultPreview() {
    TelaNotificacoes(rememberNavController(), "1A")
}