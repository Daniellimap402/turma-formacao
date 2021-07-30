import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Table } from 'primeng/table';
import { finalize } from 'rxjs/operators';
import { Page } from 'src/app/shared/page';
import { Responsavel } from './../../../domain/responsavel';
import { ResponsavelService } from './../../../shared/services/responsavel.service';

@Component({
  selector: 'app-listar-responsavel',
  templateUrl: './listar-responsavel.component.html',
  styleUrls: ['./listar-responsavel.component.css']
})
export class ListarResponsavelComponent implements OnInit {

  responsaveis: Page<Responsavel> = new Page();
  @ViewChild('tabela') tabela: Table;
  query = '';

  constructor(
    private service: ResponsavelService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.buscarResponsaveis(this.query);
  }

  buscarResponsaveis(query: string) {
    this.service.listarResponsaveis(query, this.tabela).subscribe(res => {
      this.responsaveis = res;
    });
  }

  navegarRotaCadastrar() {
    this.router.navigate(['responsaveis/cadastrar']);
  }

  remover(id: number) {
    this.service.remover(id).pipe(finalize(() => this.buscarResponsaveis(this.query))).subscribe();
  }

  editar(id: number) {
    this.router.navigateByUrl('responsaveis/cadastrar/' + id);
  }

}
