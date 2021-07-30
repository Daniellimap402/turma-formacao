import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarTarefaComponent } from './cadastrar-tarefa/cadastrar-tarefa.component';
import { ListarTarefaComponent } from './listar-tarefa/listar-tarefa.component';


const routes: Routes = [
  { path: '', component: ListarTarefaComponent },
  { path: 'cadastrar', component: CadastrarTarefaComponent },
  { path: 'cadastrar/:id', component: CadastrarTarefaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarefaRoutingModule { }
