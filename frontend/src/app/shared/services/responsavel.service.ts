import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Table } from 'primeng/table';
import { Observable } from 'rxjs';
import { RequestUtil } from '../util/request.util';
import { environment } from './../../../environments/environment.prod';
import { Responsavel } from './../../domain/responsavel';
import { Page } from './../page';

@Injectable({
    providedIn: 'root'
})
export class ResponsavelService {
    path =  environment.apiUrl + '/responsaveis/';
    constructor(private http: HttpClient) { }

    listarResponsaveis(query: string, tabela: Table): Observable<Page<Responsavel>> {
        return this.http.post<Page<Responsavel>>(`${this.path}search`, { 'query': query }, {
            params: RequestUtil.getRequestParamsTable(tabela)
        });
    }
    
    salvar(responsavel: Responsavel): Observable<any> {
        return this.http.post(this.path, responsavel);
    }

    remover(id: number): Observable<any>{
        return this.http.delete(`${this.path}/${id}`);
    }

}