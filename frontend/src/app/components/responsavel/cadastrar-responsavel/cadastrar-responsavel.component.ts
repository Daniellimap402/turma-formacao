import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { Responsavel } from './../../../domain/responsavel';
import { ResponsavelService } from './../../../shared/services/responsavel.service';

@Component({
  selector: 'app-cadastrar-responsavel',
  templateUrl: './cadastrar-responsavel.component.html',
  styleUrls: ['./cadastrar-responsavel.component.css']
})
export class CadastrarResponsavelComponent implements OnInit {

  responsavel: Responsavel = new Responsavel();

  constructor(
    private responsavelService: ResponsavelService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.buscarResponsavelRota();
  }

  private buscarResponsavelRota() {
    this.route.params.subscribe((params: Params) => {
      const id = params.id;
      const path = this.route.snapshot.routeConfig.path;
      if (id) {
        this.responsavelService.buscarPorId(id).subscribe(res => {
          this.responsavel = res;
        });
      }
    });
  }

  cadastrar() {
    this.responsavelService.salvar(this.responsavel).pipe(finalize(() => this.router.navigateByUrl('/responsaveis'))).subscribe();
  }

}
