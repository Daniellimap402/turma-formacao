import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ResponsavelService } from './services/responsavel.service';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [ResponsavelService],
    exports: [
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }
