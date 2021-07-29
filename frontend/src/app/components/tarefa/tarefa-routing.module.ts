import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarTarefaComponent } from './listar-tarefa/listar-tarefa.component';


const routes: Routes = [{
  path: '', component: ListarTarefaComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarefaRoutingModule { }
