import { Link } from "react-router-dom";

export const Footer = () => {

    return (
        <footer className="bg-light pt-1 pb-2">
            
            <div className="container">

                <div className="row mt-4 mb-5">

                    <div className="col-lg-4 col-sm-4 small">
                        <Link className="link_rodape" to="/sobre-nos"> Sobre nós </Link>
                    </div>
                    <div className="col-lg-4 col-sm-4 small"> 
                        <Link className="link_rodape" to="/central-de-ajuda"> Central de ajuda </Link> 
                    </div>
                    <div className="col-lg-4 col-sm-4 small"> 
                        <Link className="link_rodape" to="/duvidas"> Dúvidas </Link> 
                    </div>
                </div>

                <div className="row mt-4">
                    <div className="col-12 text-center"> &copy 2023 - Dream Travel Agência de Viagens </div>
                </div>
            </div>

        </footer>
    );
};