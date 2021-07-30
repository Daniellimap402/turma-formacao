import { SelectItem } from 'primeng/api';

export enum TarefaStatusEnum {

    EM_ANDAMENTO = 'EM_ANDAMENTO',
    CONCLUIDO = 'CONCLUIDO',
    SUSPENSO = 'SUSPENSO',
    PARA_FAZER = 'PARA_FAZER'

}

export const TarefaStatusEnumMapper = {
    [TarefaStatusEnum.EM_ANDAMENTO]: 'Em andamento',
    [TarefaStatusEnum.CONCLUIDO]: 'Concluido',
    [TarefaStatusEnum.SUSPENSO]: 'Suspenso',
    [TarefaStatusEnum.PARA_FAZER]: 'Para fazer'
};

export const TarefaStatusOptionsOptionNula: SelectItem[] = [
    { value: null, label: 'Selecione' },
    { value: TarefaStatusEnum.EM_ANDAMENTO, label: TarefaStatusEnumMapper[TarefaStatusEnum.EM_ANDAMENTO] },
    { value: TarefaStatusEnum.CONCLUIDO, label: TarefaStatusEnumMapper[TarefaStatusEnum.CONCLUIDO] },
    { value: TarefaStatusEnum.SUSPENSO, label: TarefaStatusEnumMapper[TarefaStatusEnum.SUSPENSO] },
    { value: TarefaStatusEnum.PARA_FAZER, label: TarefaStatusEnumMapper[TarefaStatusEnum.PARA_FAZER] },
];