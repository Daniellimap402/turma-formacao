import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Table } from 'primeng/table';
import { finalize } from 'rxjs/operators';
import { Page } from 'src/app/shared/page';
import { Tarefa } from './../../../domain/tarefa';
import { TarefaService } from './../../../shared/services/tarefa.service';

@Component({
  selector: 'app-listar-tarefa',
  templateUrl: './listar-tarefa.component.html',
  styleUrls: ['./listar-tarefa.component.css']
})
export class ListarTarefaComponent implements OnInit {

  tarefas: Page<Tarefa> = new Page();
  @ViewChild('tabela') tabela: Table;
  query = '';

  constructor(private service: TarefaService, private router: Router) { }

  ngOnInit(): void {
    this.buscarTarefas(this.query);
  }

  buscarTarefas(query: string) {

    this.service.listarTarefas(query, this.tabela).subscribe(res => {
      this.tarefas = res;
    });

  }

  navegarRotaCadastrar() {
    this.router.navigate(['/tarefas/cadastrar']);
  }

  remover(id: number) {
    this.service.remover(id).pipe(finalize(() => this.buscarTarefas(this.query))).subscribe();
  }

  editar(id: number) {
    this.router.navigateByUrl('/tarefas/cadastrar/' + id);
  }

}
