import "./SimpleButton.scss";

interface Props {
    tipo?: "button" | "submit" | "reset" | undefined;
    fill?: boolean;
    children: any;
    classExt?: string;
}

const SimpleButton = ({tipo = 'button', children, fill = true, classExt = ''}: Props) => {
    
    const returnClasses = (): string => {
        const classes: string[] = [];
        classes.push('btn-base');
        classes.push(fill ? 'btn-fill': 'btn-border');
        classes.push(classExt);
        return classes.join(' ');
    }

    return (
        <>
            <div>
                <button type={tipo} className={returnClasses()}>{children}</button>
            </div>
        </>
    )
}

export default SimpleButton;