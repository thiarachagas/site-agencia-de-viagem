import { format } from "date-fns";
import { IPassagem } from "../model/IPassagem";
import { ImgBase64 } from "./ImgBase64";
import { PrecoPassagem } from "./PrecoPassagem";

export const DetalhePassagem = (props: { passagem: IPassagem }) => {

    const passagem = props.passagem;

    return (
        <div className="row">
            <div className="col-lg-4 mt-2">
                <ImgBase64 src={passagem.destino.imagem} 
                    className="card-img-top" alt={passagem.destino.nome} />
            </div>
            <div className="col-lg-8 mt-2">
                <h4 className="card-title">{passagem.destino.nome}</h4>
                <p>{passagem.destino.descricao}</p>
                <div>
                    Data de partida: {format(passagem.dataPartida, 'dd/MM/yyyy')}
                </div>
                <div>
                    Companhia aérea: {passagem.companhiaAerea.nome}
                </div>
                <PrecoPassagem passagem={passagem} />
            </div>
        </div>
    );
};