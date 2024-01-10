import { Link } from "react-router-dom";
import { IPassagem } from "../model/IPassagem";

import { format } from 'date-fns';
import { PrecoPassagem } from "./PrecoPassagem";

export const CardPassagem = (props: { passagem: IPassagem }) => {

    const passagem = props.passagem;

    return (
        <div className="col-sm-6 col-lg-4 mt-2">
            <div className="card text-center">
                <img src={`data:image/jpeg;base64, ${passagem.destino.imagem}`} className="card-img-top"
                    alt={passagem.destino.nome} />
                <div className="card-body">
                    <h4 className="card-title">{passagem.destino.nome}</h4>
                    <div>
                        Origem: <span>{passagem.origem}</span>
                    </div>
                    <div>
                        Data de partida: <span>{format(passagem.dataPartida, 'dd/MM/yyyy')}</span>
                    </div>
                    <PrecoPassagem passagem={passagem} />

                    <Link to={`/passagem/${passagem.id}`}>Saiba Mais</Link>
                </div>
            </div>
        </div>
    );
}