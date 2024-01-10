import { IDestino } from "./IDestino";

export interface IPromocao {
    id: number;

    nome: string;

    data_inicio: Date;

    data_terminno: Date;

    desconto: number;

    destino: IDestino;
}