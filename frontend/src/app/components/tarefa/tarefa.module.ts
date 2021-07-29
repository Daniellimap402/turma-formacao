import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from './../../shared/shared.module';
import { ListarTarefaComponent } from './listar-tarefa/listar-tarefa.component';
import { TarefaRoutingModule } from './tarefa-routing.module';



@NgModule({
  declarations: [ListarTarefaComponent],
  imports: [
    SharedModule,
    CommonModule,
    TarefaRoutingModule
  ]
})
export class TarefaModule { }
