import { MouseEventHandler } from "react";
import "./SimpleButton.scss";

interface Props {
    tipo?: "button" | "submit" | "reset" | undefined;
    fill?: boolean;
    rounded?: boolean;
    children: any;
    classExt?: string;
    onClick?: MouseEventHandler<HTMLButtonElement>;
}

const SimpleButton = ({
    tipo = 'button', 
    children, 
    fill = true, 
    classExt = '', 
    rounded = false,
    onClick}: Props) => {
    
    const returnClasses = (): string => {
        const classes: string[] = [];
        classes.push('btn-base');
        classes.push(fill ? 'btn-fill': 'btn-border');
        classes.push(rounded ? 'btn-rounded': '');
        classes.push(classExt);
        return classes.join(' ');
    }

    return (
        <>
            <button type={tipo} onClick={onClick} className={returnClasses()}>{children}</button>
        </>
    )
}

export default SimpleButton;