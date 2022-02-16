import "./NotFound.scss"
import image from "../../assets/images/not_found_orange.png";
import Button from "../../components/Button/SimpleButton/SimpleButton"
import {To, useNavigate} from 'react-router-dom'

const NotFound = () => {
    const navigate = useNavigate();
    const navegar = (path: any) => {
        navigate(path)
    }

    return (
        <div className="not-found-wrapper d-flex justify-content-center flex-column align-items-center">
            <img className="mt-4" src={image} alt="not found image" />
            <p className="mt-5">Ops, a página que você procura não existe ou está termporariamente indisponivel</p>
            <div className="d-flex justify-content-between w-25 mt-5">
                <Button onClick={()=>navegar('/')} rounded={true}>Ínicio</Button>
                <Button onClick={()=>navegar(-1)} fill={false} rounded={true} >Voltar</Button>
            </div>
        </div>
    )
}

export default NotFound;