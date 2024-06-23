package com.pedromazza.agenda.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pedromazza.agenda.telas.acesso.PrimeiraTelaTurma
import com.pedromazza.agenda.telas.acesso.SegundaTelaTurma
import com.pedromazza.agenda.telas.acesso.TelaAcesso
import com.pedromazza.agenda.telas.principal.TelaCalendarioMensal
import com.pedromazza.agenda.telas.principal.TelaNotificacoes
import com.pedromazza.agenda.telas.principal.TelaPrincipal
import com.pedromazza.agenda.telas.principal.TelaTarefas
import com.pedromazza.agenda.ui.theme.AgendaEscolaTheme

class NavigationHost : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaEscolaTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.TelaAcesso.route) {
                    composable(
                        route = Screen.TelaAcesso.route
                    ) {
                        TelaAcesso(navController)
                    }
                    composable(
                        route = Screen.PrimeiraTelaTurma.route
                    ) {
                        PrimeiraTelaTurma(navController)
                    }
                    composable(
                        route = Screen.SegundaTelaTurma.route,
                        arguments = listOf(
                            navArgument("serie") { type = NavType.IntType }
                        )
                    ) { navBackStackEntry ->
                        val serie = navBackStackEntry.arguments?.getInt("serie")
                        SegundaTelaTurma(navController, serie = serie ?: 0)
                    }
                    composable(
                        route = Screen.TelaPrincipal.route,
                        arguments = listOf(
                            navArgument("turma") { type = NavType.StringType}
                        )
                    ) { navBackStackEntry ->
                        val turma = navBackStackEntry.arguments?.getString("turma")
                        TelaPrincipal(navController, turma = turma.toString())
                    }
                    composable(
                        route = Screen.CalendarioMensal.route,
                        arguments = listOf(
                            navArgument("turma") { type = NavType.StringType}
                        )
                    ) { navBackStackEntry ->
                        val turma = navBackStackEntry.arguments?.getString("turma")
                        TelaCalendarioMensal(navController, turma = turma.toString())
                    }
                    composable(
                        route = Screen.Notificacoes.route,
                        arguments = listOf(
                            navArgument("turma") { type = NavType.StringType}
                        )
                    ) { navBackStackEntry ->
                        val turma = navBackStackEntry.arguments?.getString("turma")
                        TelaNotificacoes(navController, turma = turma.toString())
                    }
                    composable(
                        route = Screen.Tarefas.route,
                        arguments = listOf(
                            navArgument("turma") { type = NavType.StringType}
                        )
                    ) { navBackStackEntry ->
                        val turma = navBackStackEntry.arguments?.getString("turma")
                        TelaTarefas(navController, turma = turma.toString())
                    }
                }
            }
        }
    }
}

