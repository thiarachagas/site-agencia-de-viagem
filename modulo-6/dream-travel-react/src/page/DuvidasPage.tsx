
export const DuvidasPage = () => {

    return (
		<div className="container mt-4 mb-5">

			<div className="row text-center text-padrao">
				<div className="col-12">
					<h3> Perguntas Frequentes</h3>
				</div>
			</div>

			<div className="accordion accordion-flush" id="accordionFlushExample">

				<div className="accordion-item">
					<h2 className="accordion-header" id="flush-headingOne">
						<button className="accordion-button collapsed" type="button" 
							data-toggle="collapse" data-target="#flush-collapseOne" 
							aria-expanded="false" aria-controls="flush-collapseOne">

							<strong> Cancelamento e reembolso </strong>

						</button>
					</h2>
					<div id="flush-collapseOne" className="accordion-collapse collapse" 
						aria-labelledby="flush-headingOne" 
						data-parent="#accordionFlushExample">

						<div className="accordion-body text-alinhado"> 
							Para solicitar o cancelamento de um bilhete, o titular
							pagante pode acessar o formulário de autoatendimento (efetuando o login). O valor líquido de
							reembolso é igual ao valor total pago pelo(s) bilhete(s) = (tarifa + taxas), subtraído do
							valor da multa cobrada.
						</div>
					</div>
				</div>

				<div className="accordion-item">
					<h2 className="accordion-header" id="flush-headingTwo">

						<button className="accordion-button collapsed" type="button" 
							data-toggle="collapse" data-target="#flush-collapseTwo" 
							aria-expanded="false" aria-controls="flush-collapseTwo">

							<strong> Remarcação </strong>
						</button>
					</h2>
					<div id="flush-collapseTwo" className="accordion-collapse collapse" 
						aria-labelledby="flush-headingTwo"
						data-parent="#accordionFlushExample">

						<div className="accordion-body text-alinhado">
							Nós não realizamos remarcações. Caso não possa viajar na data e/ou
							horário adquirido(s), recomendamos que solicite o cancelamento por meio de um dos nossos
							canais de atendimento.
						</div>
					</div>
				</div>

				<div className="accordion-item">
					<h2 className="accordion-header" id="flush-headingThree">
						<button className="accordion-button collapsed" type="button" 
							data-toggle="collapse" data-target="#flush-collapseThree" 
							aria-expanded="false" aria-controls="flush-collapseThree">

							<strong> Documentos para embarque </strong>
						</button>
					</h2>
					<div id="flush-collapseThree" className="accordion-collapse collapse"
						aria-labelledby="flush-headingThree" 
						data-parent="#accordionFlushExample">

						<div className="accordion-body text-alinhado">
							Na hora do embarque tenha em mãos o <strong> documento com foto para voos nacionais
							</strong> e
							<strong> passaporte para voos internacionais </strong>. Atenção: destinos internacionais
							podem
							pedir comprovantes extras. Consulte diretamente a companhia aérea para saber mais.
						</div>
					</div>
				</div>


				<div className="accordion-item">

					<h2 className="accordion-header" id="flush-headingFour">
						<button className="accordion-button collapsed" type="button" data-toggle="collapse"
							data-target="#flush-collapseFour" aria-expanded="false"
							aria-controls="flush-collapseFour">

							<strong> Chek-in e Horário de chegada ao aeroporto </strong>

						</button>
					</h2>
					<div id="flush-collapseFour" className="accordion-collapse collapse" aria-labelledby="flush-headingFour"
						data-parent="#accordionFlushExample">
						<div className="accordion-body text-alinhado">

							<strong> O check-in poderá ser feito 48 horas antes do embarque </strong>, através do site
							ou
							aplicativo da companhia aérea escolhida. Procure apresentar-se ao embarque com antecedência
							de
							pelo menos <strong> 2 horas para voos nacionais </strong> e <strong> 3 horas para voos
								internacionais</strong>.

						</div>
					</div>
				</div>

				<div className="accordion-item">
					<h2 className="accordion-header" id="flush-headingFive">
						<button className="accordion-button collapsed" type="button" data-toggle="collapse"
							data-target="#flush-collapseFive" aria-expanded="false"
							aria-controls="flush-collapseFive">

							<strong> Animais de estimação </strong>

						</button>
					</h2>
					<div id="flush-collapseFive" className="accordion-collapse collapse" aria-labelledby="flush-headingFive"
						data-parent="#accordionFlushExample">
						<div className="accordion-body text-alinhado">

							Para viajar com animais, é necessário entrar em contato com a companhia aérea para verificar
							as
							condições desse transporte.

						</div>
					</div>
				</div>				


			</div>
		</div>        
    );
};