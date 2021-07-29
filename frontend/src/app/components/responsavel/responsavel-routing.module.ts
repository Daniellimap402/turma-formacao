import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarResponsavelComponent } from './cadastrar-responsavel/cadastrar-responsavel.component';
import { ListarResponsavelComponent } from './listar-responsavel/listar-responsavel.component';

const routes: Routes = [
  { path: '', component: ListarResponsavelComponent },
  { path: 'cadastrar', component: CadastrarResponsavelComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResponsavelRoutingModule { }
