import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from './../../shared/shared.module';
import { ListarTarefaComponent } from './listar-tarefa/listar-tarefa.component';
import { TarefaRoutingModule } from './tarefa-routing.module';
import { CadastrarTarefaComponent } from './cadastrar-tarefa/cadastrar-tarefa.component';



@NgModule({
  declarations: [ListarTarefaComponent, CadastrarTarefaComponent],
  imports: [
    SharedModule,
    CommonModule,
    TarefaRoutingModule
  ]
})
export class TarefaModule { }
