import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Responsavel } from './../../../domain/responsavel';
import { ResponsavelService } from './../../../shared/services/responsavel.service';

@Component({
  selector: 'app-cadastrar-responsavel',
  templateUrl: './cadastrar-responsavel.component.html',
  styleUrls: ['./cadastrar-responsavel.component.css']
})
export class CadastrarResponsavelComponent implements OnInit {

  responsavel: Responsavel = new Responsavel();

  constructor(private responsavelService: ResponsavelService, private router: Router) { }

  ngOnInit(): void {
  }

  cadastrar(){    
    this.responsavelService.salvar(this.responsavel).subscribe();
    this.router.navigateByUrl('/responsaveis');
  }

}
