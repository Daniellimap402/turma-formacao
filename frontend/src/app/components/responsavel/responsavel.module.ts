import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from './../../shared/shared.module';
import { ListarResponsavelComponent } from './listar-responsavel/listar-responsavel.component';
import { ResponsavelRoutingModule } from './responsavel-routing.module';
import { CadastrarResponsavelComponent } from './cadastrar-responsavel/cadastrar-responsavel.component';

@NgModule({
  declarations: [ListarResponsavelComponent, CadastrarResponsavelComponent],
  imports: [
    SharedModule,
    CommonModule,
    ResponsavelRoutingModule
  ]
})
export class ResponsavelModule { }
