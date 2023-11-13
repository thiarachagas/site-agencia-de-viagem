package crud;

import java.util.Date;
import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.DreamTravelDAO;
import dao.FuncionárioDao;
import dao.PassagemDAO;
import dao.PedidoDAO;
import dao.PromoçoesDAO;
import dao.UsuariosDAO;
import modelos.Cliente;
import modelos.Destino;
import modelos.DreamTravel;
import modelos.Funcionário;
import modelos.Passagem;
import modelos.Pedido;
import modelos.Promoçoes;
import modelos.Usuarios;

public class GeralCRUD {

	public static void main(String[] args) {
	
// CLASSES DAO
		DreamTravelDAO DreamTravelDAO = new DreamTravelDAO();
		FuncionárioDao FuncionárioDao = new FuncionárioDao();
		
		DestinoDAO destinoDAO = new DestinoDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		PromoçoesDAO promoçoesDAO = new PromoçoesDAO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		
		
// CLASSES PARA CRIAR UM NOVO REGISTRO NO BD
		
		DreamTravel  DreamTravel = new DreamTravel();
		Funcionário funcionario = new Funcionário();
		
		Destino destino = new Destino();
		Passagem passagem = new Passagem();
		Pedido pedido = new Pedido();
		Promoçoes promoçoes = new Promoçoes();
		
		Cliente cliente = new Cliente();
		Usuarios usuario = new Usuarios();

			
// VARIÁVEIS PARA Dream Travel
	    String  Telefone = "", email = "",  endereço = "";
	    int idSite;
	        
// VARIÁVEIS FUNCIONÁRIO
	    int IdFunc;
	    String NomeFunc, CargoFunc;
	    float Salario;
		
		
// VARIÁVEIS DESTINO
	    String NomeDestino, Localizacao;
	    float preçoMedio;
	    int Qtd;
	    
	    
	    
// VARIÁVEIS PARA CLIENTE
		String CpfCliente = "", NomeCliente = "", EmailCliente = "", TelCliente = "";
		
// VARIÁVEIS PARA USUÁRIO 
		String EmailUsuario = "", SenhaUsuario = "", Nome = "", cpfCliente = "" ;
		
		
// VARIÁVEIS PEDIDO
		float PreçoCompra;
		String FormaPag; 
		String CPFCliente;
		int Id_Func;
			

				
// VARIÁVEIS PARA PASSAGEM
	int quantidade, idPassagem;
	
//	VARIÁVEIS PROMOÇÃO
	String IdPromoções, Descriçao, DestinoRelacionado, NomePromoção;
    Date DataTermino, DataInicio;
	float Desconto;
    
		
		
// VARIÁVLE ID GLOGAL
		int id;

// VARIÁVEL PARA O LOOP CADASTRO
		int opcao = 0;
				
// VARIÁVEL PARA O MENU PRINCIPAL
		int menu = 0;
		
		
Scanner s = new Scanner(System.in);
		
		System.out.println("\n===== DREAM TRAVEL=====\n");

		System.out.println("=> 1 - EMPRESA");
		System.out.println("=> 2 - FUNCIONÁRIO");
		System.out.println("=> 3 - DESTINO");
		System.out.println("=> 4 - PASSAGEM");
		System.out.println("=> 5 - PROMOÇÃO");
		System.out.println("=> 6 - PEDIDO");
		System.out.println("=> 7 - CLIENTE");
		System.out.println("=> 8 - USUÁRIO");
		menu = s.nextInt();
		
		
		switch (menu) {
		
		
// EMPRESA
		case 1: {
					
			do {

				System.out.println("===== EMPRESA =====");
				System.out.println("1 - Cadastrar unidade");
				System.out.println("2 - Excluir unidade");
				System.out.println("3 - Atualizar unidade");
				System.out.println("4 - Mostrar informações de unidade");
				System.out.println("5 - Buscar unidade por código");
				System.out.println("6 - Sair");
				opcao = s.nextInt();

				switch (opcao) {
				
				case 1: {
															
					System.out.println("Digite o NOME da unidade:");
					idSite = s.nextInt();
				DreamTravel.setIdSite(idSite);
							
					System.out.println("Digite o TELEFONE da unidade:");
					Telefone= s.next();
					DreamTravel.setTelefone(Telefone);
					
					System.out.println("Digite o E-MAIL da unidade:");
					email = s.next();
					DreamTravel.setEmail(email);

					System.out.println("Digite o ENDEREÇO da unidade:");
					endereço = s.next();
					DreamTravel.setEndereco(endereço);
					
					DreamTravelDAO.save(DreamTravel);
					
					break;
				}
				case 2: {
					
					System.out.println("Digite o IdSite da unidade para exclusão: ");
					try {
						
						idSite= s.nextInt();
						
						DreamTravelDAO.removeByidSite(idSite);
						
					} catch (Exception e) {
					
						 
						System.out.println("Não possui unidade para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o IdSite da unidade para atualizar: ");
					idSite = s.nextInt();
					
					System.out.println("Digite o novo TELEFONE da unidade: ");
					Telefone = s.next();
					DreamTravel.setTelefone(Telefone);
					
					System.out.println("Digite o novo E-MAIL da unidade: ");
					email = s.next();
					DreamTravel.setEmail(email);
					
					System.out.println("Digite o novo ENDEREÇO da unidade: ");
					endereço = s.next();
					DreamTravel.setEndereco(endereço);

					DreamTravel.setIdSite(idSite);
					DreamTravelDAO.update(DreamTravel);
					
					break;
				}
				case 4: {
									
					for (DreamTravel und : DreamTravelDAO.getDreamTravel()){

						System.out.println("Id Site: " + und.getIdSite());
						System.out.println("TELEFONE: " + und.getTelefone());
						System.out.println("E-MAIL: " + und.getEmail());
						System.out.println("ENDEREÇO: " + und.getEndereco());
						
						System.out.println("=============================== ");
					}
					
					break;
				}
				case 5: {

					System.out.print("Digite o id para buscar: ");
					idSite = s.nextInt();
					
					DreamTravel unid = new DreamTravel();

					unid = DreamTravelDAO.getUnidadesByCod(idSite);

					System.out.println("IdSite: " + unid.getIdSite());
					System.out.println("TELEFONE: " + unid.getTelefone());
					System.out.println("E-MAIL: " + unid.getEmail());
					System.out.println("ENDEREÇO: " + unid.getEndereco());

					System.out.println("============================= ");
				}
					break;

				case 6: {
					System.out.println(" === Obrigado pela preferência! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 6);

			
			break;

			}
		
		
		
		
// FUNCIONÁRIO
				case 2: {
								
					do {

						System.out.println("===== FUNCIONÁRIO =====");
						System.out.println("1 - Cadastro de funcionário");
						System.out.println("2 - Excluir funcionário");
						System.out.println("3 - Atualizar cadastro");
						System.out.println("4 - Mostrar cadastro");
						System.out.println("5 - Buscar por matrícula");
						System.out.println("6 - Sair");
						opcao = s.nextInt();

						switch (opcao) {
						
						case 1: {
												
							System.out.println("Digite o NOME do funcionário:");
							NomeFunc = s.next();
							funcionario.setNomeFunc(NomeFunc);

							System.out.println("Digite o CARGO do funcionário:");
							CargoFunc = s.next();
							funcionario.setCargoFunc(CargoFunc);
							
							System.out.println("Digite o SALÁRIO do funcionário:");
							Salario = s.nextFloat();
							funcionario.setSalario(Salario);
							
							System.out.println("Digite o CÓDIGO do Fucionário:");
							IdFunc = s.nextInt();
							funcionario.setIdFunc(IdFunc);
							
							FuncionárioDao.save(funcionario);
							break;
						}
						case 2: {
							
							System.out.println("Digite o Id do funcionário para exclusao: ");
							try {
								
								IdFunc = s.nextInt();
								
								FuncionárioDao.removeByMat(IdFunc);
								
							} catch (Exception e) {
							
								 
								System.out.println("Nenhum contato para excluir ");
							}

							break;
						}
						case 3: {

							System.out.println("Digite o Id do funcionário para atualizar: ");
							IdFunc = s.nextInt();

							System.out.println("Digite o novo CARGO do funcionário: ");
							CargoFunc = s.next();
							funcionario.setCargoFunc(CargoFunc);
							
							System.out.println("Digite o novo SALÁRIO do funcionário: ");
							Salario = s.nextFloat();
							funcionario.setSalario(Salario);
					
							
							funcionario.setIdFunc(IdFunc);
							FuncionárioDao.update(funcionario);
						}
						case 4: {
							for (Funcionário func : FuncionárioDao.getFuncionário()) {

								System.out.println("NOME DO FUNCIONÁRIO: " + func.getNomeFunc());
								System.out.println("CARGO: " + func.getCargoFunc());
								System.out.println("SALÁRIO: " + func.getSalario());
								System.out.println("Id Funcionario: " + func.getIdFunc());
								
								System.out.println("====================================");

							}
							break;
						}
						case 5: {

							System.out.print("Digite o Id do Funcionário para buscar: ");
							IdFunc = s.nextInt();
							
							Funcionário func = new Funcionário();

							func = FuncionárioDao.getFuncionárioByIdFunc(IdFunc);

							System.out.println("NOME DO FUNCIONÁRIO: " + func.getNomeFunc());
							System.out.println("CARGO: " + func.getCargoFunc());
							System.out.println("SALÁRIO: " + func.getSalario());
					

							System.out.println("============================================= ");
						}
							break;

						case 6: {
							System.out.println(" === Até logo! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 6);
					
					
					break;

					}
				
				
		
// DESTINO
				case 3: {
					
					do {

						System.out.println("===== DESTINO =====");
						System.out.println("1 - Cadastro de destino");
						System.out.println("2 - Excluir cadastro");
						System.out.println("3 - Atualizar cadastro");
						System.out.println("4 - Mostrar cadastro");
						System.out.println("5 - Buscar cadastro por id");
						System.out.println("6 - Sair");
						opcao = s.nextInt();

						switch (opcao) {
						
						case 1: {
							
							System.out.println("Digite o NOME do destino:");
							NomeDestino = s.next();
							destino.setNomeDestino(NomeDestino);
							
							System.out.println("Digite o PREÇO do destino:");
							preçoMedio = s.nextFloat();
							destino.setPrecoMedio(preçoMedio);

							System.out.println("Digite a localização do destino:");
							Localizacao = s.next();
							destino.setLocalizacao(Localizacao);
							
							System.out.println("Digite a Quantidade:");
							Qtd= s.nextInt();
							destino.setQtd(Qtd);
							
							
							destinoDAO.save(destino);
							break;
						}
						case 2: {
							
							System.out.println("Digite o id do destino para exclusao: ");
							try {
								
								id = s.nextInt();
								
								destinoDAO.removeById(id);
								
							} catch (Exception e) {
						
								 
								System.out.println("Nenhum destino para excluir ");
							}

							break;
						}
						case 3: {

							System.out.println("Digite o id do destino para atualizar: ");
							id = s.nextInt();

							System.out.println("Digite o novo NOME do destino: ");
							NomeDestino = s.next();
							destino.setNomeDestino(NomeDestino);
							
							System.out.println("Digite o novo do destino:");
							preçoMedio = s.nextFloat();
							destino.setPrecoMedio(preçoMedio);
						
							System.out.println("Digite a nova Localização do destino: ");
							Localizacao = s.next();
							 destino.setLocalizacao(Localizacao);
							
							System.out.println("Digite a nova QUANTIDADE DISPONÍVEL para destino: ");
							Qtd = s.nextInt();
							destino.setQtd(Qtd);
							

							destino.setIdDestino(id);
							destinoDAO.update(destino);
						}
						case 4: {
							for (Destino des : destinoDAO.getDestinos()) {

								System.out.println("NOME DESTINO: " + des.getNomeDestino());
								System.out.println("PRECO R$: " + des.getPrecoMedio());
								System.out.println("CATEGORIA: " + des.getLocalizacao());
								System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtd());			
							
								
								System.out.println("======================================= ");

							}
							break;
						}
						case 5: {

							System.out.print("Digite o id para buscar: ");
							id = s.nextInt();
							
							Destino des = new Destino();

							des = destinoDAO.getDestinoById(id);

							System.out.println("NOME DESTINO: " + des.getNomeDestino());
							System.out.println("PRECO R$: " + des.getPrecoMedio());
							System.out.println("CATEGORIA: " + des.getLocalizacao());
							System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtd());			
					

							System.out.println("====================================== ");
						}
							break;

						case 6: {
							System.out.println(" === Até logo! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 6);
					
					break;

					}
				
				
// PASSAGEM
				case 4: {
					
					do {

						System.out.println("===== PASSAGEM =====");
						System.out.println("1 - Cadastro de passagem com base em um DESTINO");
						System.out.println("2 - Excluir passagem");
						System.out.println("3 - Atualizar passagem");
						System.out.println("4 - Mostrar passagem");
						System.out.println("5 - Buscar por id");
						System.out.println("6 - Sair");
						opcao = s.nextInt();

						switch (opcao) {
						
						case 1: {
							System.out.println("Digite a QUANTIDADE de passagens:");
							quantidade = s.nextInt();
							passagem.setQuantidade(quantidade);
							
							System.out.println("Digite o id do destino:");
							idPassagem = s.nextInt();
							passagem.getIdPassagem();
						
							passagemDAO.save(passagem);
							break;
						}
						case 2: {
							
							System.out.println("Digite o id da passagem para exclusao: ");
							try {
								
								id = s.nextInt();
								
								passagemDAO.removeById(id);
								
							} catch (Exception e) {
						
								 
								System.out.println("Nenhuma passagem para excluir ");
							}

							break;
						}
						case 3: {

							System.out.println("Digite o id da passagem para atualizar: ");
							idPassagem = s.nextInt();

							System.out.println("Digite a Quantidade de passagens: ");
							quantidade = s.nextInt();
							passagem.setQuantidade(quantidade);
							
							System.out.println("Digite o novo id da passagem: ");
							idPassagem= s.nextInt();
							passagem.setIdPassagem(idPassagem);


							passagem.setIdPassagem(idPassagem);
							passagemDAO.update(passagem);
						}
						case 4: {
							for (Passagem pas : passagemDAO.getPassagens()) {

								System.out.println("Quantidade: " + pas.getQuantidade());
								System.out.println("Id Passagem: " + pas.getIdPassagem());
														
								System.out.println("====================================== ");

							}
							break;
						}
						case 5: {

							System.out.print("Digite o id para buscar: ");
							id = s.nextInt();
							
							Passagem pas = new Passagem();

							pas = passagemDAO.getPassagemById(id);
							
							
							System.out.println("Quantidade: " + pas.getQuantidade());
							System.out.println("Id Passagem: " + pas.getIdPassagem());
							

							System.out.println("===========================================");
						}
							break;

						case 6: {
							System.out.println(" === Agradecemos pela preferência! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 6);

					
					break;

					}
				
//PROMOÇAO 		
				case 5: {
					
					do {

						System.out.println("===== PROMOÇÃO =====");
						System.out.println("1 - Cadastrar Promoção");
						System.out.println("2 - Excluir Promoção");
						System.out.println("3 - Atualizar promoção");
						System.out.println("4 - Mostrar promoçao");
						System.out.println("5 - Buscar promoção pelo número");
						System.out.println("6 - Sair");
						opcao = s.nextInt();

						switch (opcao) {
						
						case 1: {
									
							System.out.println("Digite o nome da promoção: ");
							NomePromoção = s.toString();
							promoçoes.setNomePromocao(NomePromoção);
							
							System.out.println("Digite o Destino  da  Promoção:");
							DestinoRelacionado = s.toString();
							promoçoes.setDestinoRelacionado(DestinoRelacionado);
							
							System.out.println("Digite a Descrição:");
							Descriçao = s.toString();
							promoçoes.setDescricao(Descriçao);
							
							System.out.println("Digite o Desconto da Promoção:");
							Desconto = s.nextFloat();
						promoçoes.setDesconto(Desconto);
									
							
							promoçoesDAO.save(promoçoes);
							break;
						}
						case 2: {
							
							System.out.println("Digite o Id da promoção para exclusao: ");
							try {
								
								id = s.nextInt();
								
								promoçoesDAO.removeById(id);
								
							} catch (Exception e) {
							
								 
								System.out.println("Nenhum pedido para excluir ");
							}

							break;
						}
						case 3: {

							System.out.println("Digite o Nome da promoção para atualizar: ");
							NomePromoção = s.toString();

							System.out.println("Digite o novo Desconto da Promoção: ");
							Desconto = s.nextFloat();
							promoçoes.setDesconto(Desconto);
							
							System.out.println("Digite a nova Descrição: ");
							Descriçao = s.next();
							promoçoes.setDescricao(Descriçao);
							
												
							promoçoes.setIdPromocoes(IdPromoções);
							promoçoesDAO.update(promoçoes);
						}
						case 4: {
							for (Promoçoes prom : PromoçoesDAO.getPromoçoes()) {
								
				
								System.out.println("Desconto R$: " + prom.getDesconto());
								System.out.println("Nome da Promoção: " + prom.getNomePromocao());
								System.out.println("Descrição " + prom.getDescricao());
								System.out.println("Destino: " + prom.getDestinoRelacionado());
								
								System.out.println("============================================== ");

							}
							break;
						}
						case 5: {

							System.out.print("Digite o NÚMERO da promoção para busca: ");
							id = s.nextInt();
							
							Promoçoes promo = new Promoçoes();

							promo = PromoçoesDAO.getPromoçoesById(id);

							System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
							System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
							System.out.println("MATR. DO FUNCIONÁRIO: " + ped.getMatFunc());

							System.out.println("DATA DO PEDIDO: " + ped.getDataPedido());

							System.out.println("----------------------------------- ");
						}
							break;

						case 6: {
							System.out.println(" === Agradecemos pela preferência! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 6);
					
					
					break;

					}
					

				}

			s.close();

		}

}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		