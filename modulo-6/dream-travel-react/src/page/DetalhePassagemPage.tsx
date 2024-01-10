import { useSelector } from "react-redux";
import { RootState } from "../state/store";
import { useParams, Navigate } from "react-router-dom";
import { DetalhePassagem } from "../component/DetalhePassagem";

export const DetalhePassagemPage = () => {

    const { id } = useParams();
    const passagens = useSelector((state: RootState) => state.passagem.passagens);

    if (id === undefined) {
        return <Navigate to="/" />
    }

    const idNum = +id;
    const passagem = passagens.find(p => p.id === idNum);

    if (passagem == null) {
        return <div>
            Passagem de ID {id} não encontrada!
        </div>
    }

    return (
        <div>
            <main className="container mb-5">
                
                <div className="col-12 mt-5 text-center">
                    <h2 className="mb-4 text-padrao">Passagem</h2>			
                </div> 

                <div>
                    <DetalhePassagem passagem={passagem} />                    
                </div>
                
            </main>
        </div>
    );
};