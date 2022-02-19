import React from 'react';

const isEmpty = (data: string | any[] | null): boolean => {
    if(data === null) return false;

    if(Array.isArray(data) && data.length === 0)
        return true;

    if(typeof data === "string" && data === "")
        return true;

    return false;
}

const inLength = (data: string | null, length: number): boolean => {
    if(data === null)
        return false;

    if(data.length === length)
        return true

    return false;
}

const isNull = (data: any | null): boolean => {
    if (data === null) return true;
    return false;
}

const nonNull = (data: any | null): boolean => {
    return !isNull(data);
}

const matches = (data1: string | number | null, data2: string | number | null) => {
    if(data1 === data2) return true;
}

const Validation = React.createContext({
    isEmpty,
    isNull,
    nonNull,
    inLength,
    matches
});


export default Validation;