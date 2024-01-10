import { Link } from "react-router-dom";
import { IDestino } from "../model/IDestino";

export const CardDestino = (props: { destino: IDestino }) => {

    const destino = props.destino;

    console.log(destino);

    return (
        <div className="row mt-5" >
            
            <div className="col-lg-5">	
                <img className="img-fluid" src={`data:image/jpeg;base64, ${destino.imagem}`} />	
            </div>

            <div className="col-lg-6 text-center">

                <h6 className="text-justify mb-2 mt-2 font-weight-bold">{destino.nome}</h6>

                <p className="text-justify">{destino.descricao}</p>

                <p>Localização: {destino.localizacao}</p>

                <p>Preço médio: R$ {destino.precoMedio}</p>
            </div>

        </div>
    );
};