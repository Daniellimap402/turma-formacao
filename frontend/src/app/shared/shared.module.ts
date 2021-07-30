import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ResponsavelService } from './services/responsavel.service';
import { TarefaService } from './services/tarefa.service';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [
        ResponsavelService,
        TarefaService 
    ],
    exports: [
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }
