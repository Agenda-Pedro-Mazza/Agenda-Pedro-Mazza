package com.pedromazza.agenda.navigation

sealed class Screen(val route: String) {
    data object TelaAcesso : Screen("telaAcesso")
    data object PrimeiraTelaTurma : Screen("primeiraTelaTurma")
    data object SegundaTelaTurma : Screen("segundaTelaTurma/{serie}")
        fun serie(serie: Int) = "segundaTelaTurma/$serie"
    data object TelaPrincipal : Screen("telaPrincipal/{turma}")
        fun turmaTelaPrincipal(turma: String) = "telaPrincipal/$turma"
    data object CalendarioMensal : Screen("calendarioMensal/{turma}")
        fun turmaCalendarioMensal(turma: String) = "calendarioMensal/$turma"
    data object Notificacoes : Screen("notificacoes/{turma}")
        fun turmaNotificacoes(turma: String) =  "notificacoes/$turma"
    data object Tarefas : Screen("tarefas/{turma}")
        fun turmaTarefas(turma: String) = "tarefas/$turma"
}