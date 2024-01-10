import { Link } from "react-router-dom";

export const Header = () => {

    return (
		<header>
			<nav className="bg-white navbar navbar-expand-sm navbar-light bg-light">
				
				<a className="navbar-brand" href="#">
					<img src="/img/agencia_viagens_small.png" alt="Logo" height="120px" />
				</a>
				
				<button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
					<span className="navbar-toggler-icon"></span>
				</button>
				
				<div className="collapse navbar-collapse" id="collapsibleNavbar">
					<ul className="navbar-nav ml-auto">
						<li className="nav-item">
							<Link className="nav-link" to="/" >
								Home
							</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link" to="/destino" >
								Destinos
							</Link>
						</li>
					</ul>
				</div>
			</nav>
		</header>
    );
};