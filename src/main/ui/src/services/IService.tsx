import axios, { AxiosResponse } from "axios";

export default abstract class IService
{
    private _baseUrl: string = 'http://localhost:8080/api';

    httpGet (url: string): Promise<AxiosResponse<any, any>> {
        return axios.get(this._baseUrl + url);
    }
}