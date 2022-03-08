import "./Footer.scss";
import { Link } from "react-router-dom";

const Footer = () => {
  const itens = [
    {
      titulo: "Empresa",
      itens: [
        { titulo: "Sobre nós", link: "/sobre" },
        { titulo: "Localização", link: "/localizacao" },
        { titulo: "Novidades", link: "/novidades" },
        { titulo: "O que está por vir", link: "/novidades/embreve" },
      ],
    },
    {
      titulo: "Serviços",
      itens: [
        { titulo: "Buscar Professores", link: "/professores" },
        { titulo: "Buscar matérias", link: "/materias" },
        { titulo: "Comprar moedas", link: "/moedas" },
      ],
    },
    {
      titulo: "Contatos",
      itens: [
        { titulo: "Instagram", link: "/intagram" },
        { titulo: "Facebook", link: "/facebook" },
        { titulo: "Youtube", link: "/youtube" },
        { titulo: "Linkedin", link: "/linkedin" },
        { titulo: "Twitter", link: "/twitter" },
      ],
    },
  ];

  return (
    <footer>
      <section className="row m-0">
        <div className="col-3 footer-sec">
          <h2>Ceos</h2>
          <p>Criado para a busca e adoção de serviços</p>
        </div>
        <div className="col-9 h-100 row footer-sec d-flex align-items-start">
          {itens.map((item, idx) => (
            <div key={`${item.titulo}-${idx}`} className={`col-${ Math.floor(12/itens.length)} d-flex flex-column `}>
                <h3>{item.titulo}</h3>
                {item.itens.map((link, sidx) => <Link key={`${link.titulo}-${sidx}`} to={link.link}>{link.titulo}</Link>)}
            </div>
          ))}
        </div>
      </section>
      <section>
          <p className="m-2">© 2022 Ceos Technologies Inc.</p>
      </section>
    </footer>
  );
};

export default Footer;
