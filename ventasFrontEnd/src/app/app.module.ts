import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { RegistroClienteComponent } from './registro-cliente/registro-cliente.component';
import { RegistroVentaComponent } from './registro-venta/registro-venta.component';


@NgModule({
  declarations: [
    AppComponent,
    RegistroClienteComponent,
    RegistroVentaComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
