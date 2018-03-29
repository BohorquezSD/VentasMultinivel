import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { HttpParams } from '@angular/common/http';
import { log } from 'util';

@Injectable()
export class ConexionOracleService {  

  headers = new Headers({
    'Content-Type': 'application/x-www-form-urlencoded',
  });

  url: string = "http://localhost:3030/";
  postPago: string = 'postPagar';

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

  oracleGet(tabla: string, parametros: any) {
    return this.http.get(this.url + tabla, {
      headers: this.headers,
      //params: (parametros!=null)?new URLSearchParams(this.addUserParams(parametros)).toString():'',
      params: new URLSearchParams(this.addUserParams(parametros)).toString(),
    });
    //}).toPromise();   
  }

  oraclePost(tabla, parametros) {
    //let body = new URLSearchParams(parametros).toString();
    return this.http.post(this.url + tabla, parametros, {
      headers: this.headers,
      params: new URLSearchParams(this.addUserParams(parametros)).toString()
    });
    //}).toPromise();
  }

  postPagar(parametro: any) {
    return this.oraclePost(this.postPago, parametro);
  }

  getLogin(user: string, pass: string) {
    localStorage.setItem('user', user);
    localStorage.setItem('pass', pass);
    return this.oracleGet("login", null);
  }

}
