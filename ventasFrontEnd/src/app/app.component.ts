import { Component } from '@angular/core';
import {ConexionOracleService} from './service/conexion-oracle.service'
import { log } from 'util';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  ngOnInit(): void {

  }

  user = {
    name: "",
    pass: "",
  };
  logged = false;
  texto: string = "";
  title = 'VENTAS MULTINIVEL';

  hora = new Date();


  constructor(private backEnd: ConexionOracleService) {
    setInterval(() => {
      this.hora = new Date();
    }, 1);
  }

  logout() {
    localStorage.removeItem("user");
    localStorage.removeItem("pass");
    this.logged = false;
  }
  login() {
    this.backEnd.getLogin(this.user.name, this.user.pass).subscribe(
      respuesta => {
        let jsonRespuesta = respuesta.json();
        this.texto=jsonRespuesta.nombre;
        if (this.texto == this.user.name) {
          this.logged = true;
        } else {
          alert("Usuario/contraseña erroneos \n" + this.texto);
        }  
        this.user.name = "";
        this.user.pass = "";
      });
  }
  isDBA(){
    if(this.user.name=="system"){
      return true;
    }
  }

}
