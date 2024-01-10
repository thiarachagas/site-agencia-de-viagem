import { ICompanhiaAerea } from "./ICompanhiaAerea";
import { IDestino } from "./IDestino";
import { IPromocao } from "./IPromocao";

export interface IPassagem {

    id: number;

    dataPartida: string;

    origem: string;

    destino: IDestino;

    promocao: IPromocao;

    companhiaAerea: ICompanhiaAerea;
}
