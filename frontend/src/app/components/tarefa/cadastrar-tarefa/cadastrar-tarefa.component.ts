import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SelectItem } from 'primeng';
import { finalize } from 'rxjs/operators';
import { TarefaStatusOptionsOptionNula } from '../../../shared/enum/tarefa-status.enum';
import { Anexo } from './../../../domain/anexo';
import { Tarefa } from './../../../domain/tarefa';
import { ResponsavelService } from './../../../shared/services/responsavel.service';
import { TarefaService } from './../../../shared/services/tarefa.service';

@Component({
  selector: 'app-cadastrar-tarefa',
  templateUrl: './cadastrar-tarefa.component.html',
  styleUrls: ['./cadastrar-tarefa.component.css']
})
export class CadastrarTarefaComponent implements OnInit {

  tarefa: Tarefa = new Tarefa();
  responsaveis: SelectItem[] = [];
  responsavelSelecionado: SelectItem;
  status = TarefaStatusOptionsOptionNula;
  exibirModalAnexo = false;
  anexo: Anexo = new Anexo();
  
  constructor(
    private tarefaService: TarefaService,
    private router: Router,
    private responsavelService: ResponsavelService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.buscarTarefaRota();
    this.buscarResponsaveis();
  }

  private buscarTarefaRota() {
    this.route.params.subscribe((params: Params) => {
      const id = params.id;
      const path = this.route.snapshot.routeConfig.path;
      if (id) {
        this.tarefaService.buscarPorId(id).subscribe(res => {
          this.tarefa = res;
        });
      }
    });
  }

  cadastrar() {
    this.tarefa.idResponsavel = this.responsavelSelecionado.value;    
    this.tarefaService.cadastrar(this.tarefa).pipe(finalize(() => this.router.navigateByUrl('/tarefas'))).subscribe();
  }

  buscarResponsaveis() {
    this.responsavelService.buscarDominiosFixos().subscribe(res => {
      this.responsaveis = res;
    });
  }

  fecharModalFormulario(){
    this.exibirModalAnexo = false;
    this.anexo = new Anexo();
  }

  adicionarAnexo(){
    this.tarefa.anexos.push(this.anexo);
    this.fecharModalFormulario();
  }

  abrirModalAnexo(){
    this.exibirModalAnexo = true;
  }

}
