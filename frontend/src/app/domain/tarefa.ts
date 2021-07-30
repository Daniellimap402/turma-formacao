import { TarefaStatusEnum } from '../shared/enum/tarefa-status.enum';
import { Anexo } from './anexo';
export class Tarefa{
    id: number;
    nome: string;
    dataConclusao: string;
    dataInicio: string;
    status: TarefaStatusEnum;
    nomeAnexos: string;
    nomeResponsavel: string;
    idResponsavel: number;
    anexos: Anexo[] = [];
}