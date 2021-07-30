import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Table } from 'primeng/table';
import { Observable } from 'rxjs';
import { RequestUtil } from '../util/request.util';
import { environment } from './../../../environments/environment.prod';
import { Tarefa } from './../../domain/tarefa';
import { Page } from './../page';

@Injectable({
    providedIn: 'root'
})
export class TarefaService {
    path =  environment.apiUrl + '/tarefas/';
    constructor(private http: HttpClient) { }

    listarTarefas(query: string, tabela: Table): Observable<Page<Tarefa>> {
        return this.http.post<Page<Tarefa>>(`${this.path}search`, { 'query': query }, {
            params: RequestUtil.getRequestParamsTable(tabela)
        });
    }

    cadastrar(tarefa: Tarefa): Observable<any> {
        return this.http.post<any>(this.path, tarefa);
    }

    remover(id: number): Observable<any> {
        return this.http.delete<any>(this.path + id);
    }

    buscarPorId(id: number): Observable<Tarefa> {
        return this.http.get<Tarefa>(this.path + id);
    }

}