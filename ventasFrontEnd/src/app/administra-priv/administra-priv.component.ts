import { Component, OnInit } from '@angular/core';
import { ConexionOracleService } from '../service/conexion-oracle.service';

@Component({
  selector: 'app-administra-priv',
  templateUrl: './administra-priv.component.html',
  styleUrls: ['./administra-priv.component.scss']
})
export class AdministraPrivComponent implements OnInit {

  constructor(private backEnd: ConexionOracleService) { }

  public busqueda :string;
  public roles;
  public adms;
  public defs;

  public rol;


  ngOnInit() {
  }

  verRoles() {
    this.backEnd.getRoles(this.busqueda).subscribe(
      respuesta => {
        let jsonRespuesta = respuesta.json();
        this.roles = jsonRespuesta.RoleAsociado;
        this.adms = jsonRespuesta.adm;
        this.defs = jsonRespuesta.def;
      });
  }
}
