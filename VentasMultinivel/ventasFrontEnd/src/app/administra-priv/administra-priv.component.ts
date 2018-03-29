import { Component, OnInit } from '@angular/core';
import { ConexionOracleService } from '../service/conexion-oracle.service';
import { Role } from '../roles/role'
import { Privilegio } from '../privilegios/privilegio'

@Component({
  selector: 'app-administra-priv',
  templateUrl: './administra-priv.component.html',
  styleUrls: ['./administra-priv.component.scss']
})
export class AdministraPrivComponent implements OnInit {

  constructor(private backEnd: ConexionOracleService) { }

  public busqueda :string;
  public roles;
  public privs;
  
  public privilegio: Privilegio = new Privilegio();
  public role :Role =new Role();

  ngOnInit() {
  }

  verRoles() {
    this.backEnd.getRoles(this.busqueda, null).subscribe(
      respuesta => {
        let jsonRespuesta = respuesta.json();
        if (jsonRespuesta.roles) {
          this.roles = jsonRespuesta.roles;
        } else {
          alert("Privilegios insuficientes \n" + jsonRespuesta.error);
        }  
      });
  }
  verPrivilegios() {
    this.backEnd.getPrivilegios(this.busqueda, null).subscribe(
      respuesta => {
        let jsonRespuesta = respuesta.json();
        if (jsonRespuesta.privs) {
          this.privs = jsonRespuesta.privs;
        } else {
          alert("Privilegios insuficientes \n" + jsonRespuesta.error);
        }
      });
  }
}
