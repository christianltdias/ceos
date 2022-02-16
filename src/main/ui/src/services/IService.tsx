import axios, { AxiosResponse } from "axios";
import {getToken} from "../hooks/TokenUtils"

export default abstract class IService {
  private _baseUrl: string = "http://localhost:8080/api";
  private token: string;

  constructor() {
    const token = getToken();
    this.token = token == null ? "" : token;
  }

  protected httpPostSemHeader(
    url: string,
    data: any
  ): Promise<AxiosResponse<any, any>> {
    return axios.post(this._baseUrl + url, data);
  }

  protected httpGet(url: string): Promise<AxiosResponse<any, any>> {
    return axios.get(this._baseUrl + url, {
      headers: {
        Authorization: this.token,
      },
    });
  }

  protected httpPost(url: string, data: any): Promise<AxiosResponse<any, any>> {
    return axios.post(this._baseUrl + url, data, {
      headers: {
        Authorization: this.token,
      },
    });
  }
}
