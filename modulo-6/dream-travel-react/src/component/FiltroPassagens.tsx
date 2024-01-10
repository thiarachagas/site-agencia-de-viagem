import { useState } from "react";
import { MouseEvent } from "react";
import { useDispatch } from "react-redux";
import { AppDispatch } from "../state/store";
import { IFiltroPassagem } from "../model/IFiltroPassagem";
import { filtrar } from "../state/passagem/passagemSlice";

export const FiltroPassagens = () => {

    const dispatch = useDispatch<AppDispatch>();

    const [origem, setOrigem] = useState('');
    const [destino, setDestino] = useState('');
    const [dataPartidaMin, setDataPartidaMin] = useState('');
    const [dataPartidaMax, setDataPartidaMax] = useState('');

    const filterData = (event: MouseEvent<HTMLElement>) => {
        event.preventDefault();

        const filtro: IFiltroPassagem = {
            origem, destino, dataPartidaMin, dataPartidaMax
        };

        dispatch(filtrar(filtro));
    }

    return (
        <form>
            <div className="row">
                <div className="col-md-6">
                    <h3 className="mt-3 text-light text-justify"> BUSCAR PASSAGENS </h3>
                </div>
            </div>

            <div className="row mt-3">
                <div className="col-md-6">
                    <label className="text-light form-label" htmlFor="saida">De onde você está saindo?</label>

                    <input type="text" className="form-control" 
                        placeholder="Informe o ponto de partida"
                        value={origem} onChange={(event) => setOrigem(event.target.value)} />
                </div>

                <div className="col-md-6">
                    <label className="text-light form-label" htmlFor="destino">Para onde você vai?</label>

                    <input type="text" className="form-control"
                        placeholder="Informe o destino"
                        value={destino} onChange={(event) => setDestino(event.target.value)} />
                </div>
            </div>

            <div className="row mt-3">
                <div className="col-md-6">
                    <label className="text-light form-label" htmlFor="data">Intervalo da data de partida:</label>
                    <div className="row">								

                        <div className="col-md-6">									
                            <input className="form-control" type="date"
                                value={dataPartidaMin} 
                                onChange={(event) => setDataPartidaMin(event.target.value)} />
                        </div>								

                        <div className="col-md-6">									
                            <input className="form-control" type="date"
                                value={dataPartidaMax}
                                onChange={(event) => setDataPartidaMax(event.target.value)} />
                        </div>
                    </div>
                </div>

                <div className="col-md-6 mb-3 text-justify">
                    <button className="btn bg-buscar" onClick={filterData}>
                        BUSCAR PASSAGENS
                    </button>
                </div>
            </div>

            <div className="row mt-3">
            </div>
        </form>
    );
};