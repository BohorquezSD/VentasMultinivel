import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { RegistroClienteComponent } from '../registro-cliente/registro-cliente.component';
import { RegistroVentaComponent } from '../registro-venta/registro-venta.component';

const routes: Routes = [
  {
    path: 'registroCliente',  //parent path, define the component that you imported earlier..
    component: RegistroClienteComponent,
  },
  {
    path: 'registroVenta',  //parent path, define the component that you imported earlier..
    component: RegistroVentaComponent,
  }
];

@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
