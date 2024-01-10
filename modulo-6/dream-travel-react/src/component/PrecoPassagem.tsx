import { IPassagem } from "../model/IPassagem";

export const PrecoPassagem = (props: { passagem: IPassagem }) => {

    const passagem = props.passagem;

    return (
        passagem.promocao ? 
            <div >
                <p className="card-text text-danger m-0 small">
                    De R$ <del> R$ {passagem.destino.precoMedio} </del> Por
                </p>
                <h4 className="card-text text-success">
                    R$ {passagem.destino.precoMedio - passagem.promocao.desconto}
                </h4>
            </div>
            :
            <div >
                R$ {passagem.destino.precoMedio}
            </div>
    );
};