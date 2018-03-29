import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { HttpParams } from '@angular/common/http';
import { log } from 'util';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class ConexionOracleService {  
  
  headers = new Headers({
    'Access-Control-Allow-Origin': '*',
    'Content-Type' : 'application/json',
    'Accept': 'application/json',
    });

  url: string = "http://localhost:8080/VentasBackEnd/rest/";
  postPago: string = 'postPagar';
  prueba: string = 'login/'

  constructor(private http: Http) { }

  addUserParams(parametros: any) {
    if (parametros == null) {
      parametros = {};
    }
    parametros['user'] = {};
    parametros['pass'] = {};
    parametros.user = localStorage.getItem('user');
    parametros.pass = localStorage.getItem('pass');
    return parametros;
  }

  oracleGet(tabla: string, parametros: any): Observable<Response> {
    return this.http.get(this.url + tabla, {
      headers: this.headers,
      params: new URLSearchParams(this.addUserParams(parametros)).toString(),
    }).catch((error:Response)=>{
      if (error.status === 0) {
        //Conexión reusada, no hay conexión con el servidor
        alert("Se ha producido un error. No hay conexión con el servidor")
      }
      else if (error.status === 500) {
        //Error interno del servidor
        alert("Se ha producido un error. Error interno en el servidor");
      } else if (error.status === 502) {
        //Bad gateway, servicio externo no respondió
        alert("Servicio externo inaccesible. Intente nuevamentes más tarde.");
      }
      return Observable.throw(error.json().error); 
    });
  }

  oraclePost(tabla, parametros): Observable<Response>  {
    //let body = new URLSearchParams(parametros).toString();
    return this.http.post(this.url + tabla, parametros, {
      headers: this.headers,
      params: new URLSearchParams(this.addUserParams(parametros)).toString()
    }).catch((error: Response) => {
      if (error.status === 0) {
        //Conexión reusada, no hay conexión con el servidor
        alert("Se ha producido un error. No hay conexión con el servidor")
      }
      else if (error.status === 500) {
        //Error interno del servidor
        alert("Se ha producido un error. Error interno en el servidor");
      } else if (error.status === 502) {
        //Bad gateway, servicio externo no respondió
        alert("Servicio externo inaccesible. Intente nuevamentes más tarde.");
      }
      return Observable.throw(error.json().error);
    });
  }

  postPagar(parametro: any) {
    return this.oraclePost(this.postPago, parametro);
  }


  getLogin(user: string, pass: string) {
    localStorage.setItem('user', user);
    localStorage.setItem('pass', pass);
    return this.oracleGet("login", null);
  }

  getRoles(search: string, parametros: any){
    return this.http.get(this.url + "verRoles", {
      headers: this.headers,
      params: new URLSearchParams(this.addUserParams(parametros)).toString() + "&search=" + search,
    }).catch((error: Response) => {
      if (error.status === 0) {
        //Conexión reusada, no hay conexión con el servidor
        alert(error.statusText)
      }
      else if (error.status === 500) {
        //Error interno del servidor
        alert("Se ha producido un error. Error interno en el servidor");
      } else if (error.status === 502) {
        //Bad gateway, servicio externo no respondió
        alert("Servicio externo inaccesible. Intente nuevamentes más tarde.");
      }
      return Observable.throw(error.json().error);
    });
  }

  getPrivilegios(search: string, parametros: any) {
    return this.http.get(this.url + "verPrivs", {
      headers: this.headers,
      params: new URLSearchParams(this.addUserParams(parametros)).toString() + "&search=" + search,
    }).catch((error: Response) => {
      if (error.status === 0) {
        //Conexión reusada, no hay conexión con el servidor
        alert(error.statusText)
      }
      else if (error.status === 500) {
        //Error interno del servidor
        alert("Se ha producido un error. Error interno en el servidor");
      } else if (error.status === 502) {
        //Bad gateway, servicio externo no respondió
        alert("Servicio externo inaccesible. Intente nuevamentes más tarde.");
      }
      return Observable.throw(error.json().error);
    });
  }

}
