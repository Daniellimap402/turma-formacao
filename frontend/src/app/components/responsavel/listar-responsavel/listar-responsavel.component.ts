import { Component, OnInit, ViewChild } from '@angular/core';
import { Table } from 'primeng/table';
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

  constructor(private service: ResponsavelService) { }

  ngOnInit(): void {
    this.buscarResponsaveis(this.query);
  }

  buscarResponsaveis(query: string){
    console.log('query', query);
    
    this.service.listarResponsaveis(query, this.tabela).subscribe(res => {
      this.responsaveis = res;
      console.log(this.responsaveis);
    });   
    
  }

}
