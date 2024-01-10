import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../state/store";
import { adicionar, buscarDestinos } from "../state/destino/destinoSlice";
import { IDestino } from "../model/IDestino";
import { useEffect } from "react";
import { Link } from "react-router-dom";
import { CardDestino } from "../component/CardDestino";

export const DestinoPage = () => {
    const destinos = useSelector((state: RootState) => state.destino.destinos);
    const dispatch = useDispatch<AppDispatch>();

    useEffect(() => {
        dispatch(buscarDestinos());
    }, [dispatch]);

    return (
        <div>
            <div className="container-fluid">

                <div className="row mt-4">
                    <div className="col-12 text-center">
                        <h4 className="text-danger mb-4">NACIONAIS</h4>
                    </div>
                </div>

            </div>

            <div className="container ">

                { destinos.filter(d => ! d.internacional).map((d, key) => <CardDestino key={key} destino={d} />) }

            </div>

            <div className="container mt-5 mb-4">

                <div className="row ">
                    <div className="col-12 text-center">
                        <h4 className="text-danger">INTERNACIONAIS</h4>
                    </div>

                </div>

            </div>

            <div className="container">
                { destinos.filter(d => d.internacional).map((d, key) => <CardDestino key={key} destino={d} />) }
            </div>

            <div className="container">
                <i className="ri-arrow-up-s-line" id="icon-top"></i>

                <div className="mt-4">
                    <h4>Formas de Pagamento</h4>
                    <img src="img/formasdepag.png" alt="Formas de Pagamento" className="img-fluid" />
                </div>
            </div>

        </div>
    );
};