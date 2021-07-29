import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { ResponsavelModule } from './components/responsavel/responsavel.module';
import { TarefaModule } from './components/tarefa/tarefa.module';

const routes: Routes = [
  { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros' } },
  { path: 'login-success', component: LoginSuccessComponent },
  { path: 'responsaveis', loadChildren: () => ResponsavelModule },
  { path: 'tarefas', loadChildren: () => TarefaModule }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
