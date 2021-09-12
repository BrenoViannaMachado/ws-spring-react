import { Link } from "react-router-dom";
import Footer from "../../components/Footer";
import NavBar from "../../components/NavBar";

function Home() {
  return (
    <>
      <NavBar />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4">Brenola Vendas</h1>
          <p className="lead">Analise de desempenho de diversas vendas</p>
          <hr />
          <p>Esta aplicação consiste em exibir um dashboard a partir de dados fornecidos por um backend construído com SpringBoot para fins de teste!</p>
          <Link className="btn btn-primary btn-large" to="/dashboard">
            Acessar dashboard
          </Link>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Home;