import { FiltroPassagens } from "../component/FiltroPassagens";
import { CardPassagem } from "../component/CardPassagem";
import { useEffect } from "react";
import { buscarPassagens } from "../state/passagem/passagemSlice";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../state/store";

// https://hemanthkollanur.medium.com/react-fetch-data-with-redux-toolkit-using-createasyncthunk-tutorial-eeb4e817477e
export const HomePage = () => {

    const passagens = useSelector((state: RootState) => state.passagem.filtradas);
    const dispatch = useDispatch<AppDispatch>();

    useEffect(() => {
        dispatch(buscarPassagens());
    }, [dispatch]);

    return (
        <div>            
            <div className="container-fluid bg-degrade">

                <div className="container">
                    <FiltroPassagens />
                </div>

            </div>

            <main className="container-fluid mb-5">

                <div className="col-12 mt-5 text-center">
                    <h2 className="mb-4 text-padrao"> Viagens em Destaque</h2>
                    <p> Aqui, você encontrará as melhores opções de viagens para os destinos mais incríveis do mundo. </p>
                </div>

                <div className="row">
                    {
                        passagens.length === 0 ? 
                            <div>Inicie uma consulta</div> :
                            passagens.map((p, key) => <CardPassagem key={key} passagem={p} />)
                    }
                </div>
            </main>
        </div>
    );
};