package com.pedromazza.agenda.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pedromazza.agenda.R
import com.pedromazza.agenda.navigation.Screen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    navController: NavController,
    turma: String,
    route: String
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet  {
                Text(text = stringResource(id = R.string.app_name))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = R.string.bt_tela_inicial)) },
                    selected = (route == Screen.TelaPrincipal.turmaTelaPrincipal(turma)),
                    icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Voltar para a tela inicial")
                    },
                    onClick = {
                        if(route != Screen.TelaPrincipal.turmaTelaPrincipal(turma)) navController.navigate(Screen.TelaPrincipal.turmaTelaPrincipal(turma))
                        coroutineScope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = R.string.bt_notificacoes)) },
                    selected = (route == Screen.Notificacoes.turmaNotificacoes(turma)),
                    icon = {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Mostrar notificações")
                    },
                    onClick = {
                        if(route != Screen.Notificacoes.turmaNotificacoes(turma)) navController.navigate(Screen.Notificacoes.turmaNotificacoes(turma))
                        coroutineScope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = R.string.bt_tarefas)) },
                    selected = (route == Screen.Tarefas.turmaTarefas(turma)),
                    icon = {
                        Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = "Mostrar tarefas pendentes")
                    },
                    onClick = {
                        if(route != Screen.Tarefas.turmaTarefas(turma)) navController.navigate(Screen.Tarefas.turmaTarefas(turma))
                        coroutineScope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id =R.string.bt_calendario)) },
                    selected = (route == Screen.CalendarioMensal.turmaCalendarioMensal(turma)),
                    icon = {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = "Mostrar calendário mensal")
                    },
                    onClick = {
                        if(route != Screen.CalendarioMensal.turmaCalendarioMensal(turma)) navController.navigate(Screen.CalendarioMensal.turmaCalendarioMensal(turma))
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            }
        },
        gesturesEnabled = true,
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        if(route == Screen.TelaPrincipal.turmaTelaPrincipal(turma)) {
                            when(turma) {
                                "1A" -> Text(stringResource(id = R.string.bt_turma1_A))
                                "1B" -> Text(stringResource(id = R.string.bt_turma1_B))
                                "1C" -> Text(stringResource(id = R.string.bt_turma1_C))
                                "1D" -> Text(stringResource(id = R.string.bt_turma1_D))
                                "2A" -> Text(stringResource(id = R.string.bt_turma2_A))
                                "2B" -> Text(stringResource(id = R.string.bt_turma2_B))
                                "2C" -> Text(stringResource(id = R.string.bt_turma2_C))
                                "3A" -> Text(stringResource(id = R.string.bt_turma3_A))
                                "3D" -> Text(stringResource(id = R.string.bt_turma3_B))
                                "3C" -> Text(stringResource(id = R.string.bt_turma3_C))
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menu lateral"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Abrir configurações"
                            )
                        }
                    }
                )
            }
        ) {
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun DefaultPreview() {
    NavigationDrawer(rememberNavController(),"1A", Screen.TelaPrincipal.turmaTelaPrincipal("1A"))
}