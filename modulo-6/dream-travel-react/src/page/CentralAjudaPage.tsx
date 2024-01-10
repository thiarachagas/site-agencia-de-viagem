
export const CentralAjudaPage = () => {

    return (
        <div className="container-fluid mb-4">        
            <section className="help-section">
                <div className="container">
                    <h2 className="text-center">Central de Ajuda</h2>
                    <p>Estamos aqui para ajudar! Escolha a opção mais conveniente para entrar em contato conosco.</p>
    
                    <div className="contact-options">
                        <div className="row">
    
                            <div className="col-sm-12 col-md-4">
                                <div className="card contact-card">
                                    <div className="card-body">
                                        <h5 className="card-title">Contato pelo WhatsApp</h5>
                                        <p className="card-text">Converse conosco via WhatsApp para assistência rápida.</p>
                                        <a href="https://api.whatsapp.com/send?phone=SEU_NUMERO_DE_TELEFONE_COM_DDI"
                                            className="btn btn-success" target="_blank">Iniciar Conversa</a>
                                    </div>
                                </div>
                            </div>
    
                            <div className="col-sm-12 col-md-4">
                                <div className="card contact-card">
                                    <div className="card-body">
                                        <h5 className="card-title">Canal Telefônico</h5>
                                        <p className="card-text">Ligue para nós para assistência imediata.</p>
                                        <p>Número de Telefone: 022 994567804</p>
                                        <p>Horário de Atendimento: Seg-Sex, 9h às 18h</p>
                                    </div>
                                </div>
                            </div>
    
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
};