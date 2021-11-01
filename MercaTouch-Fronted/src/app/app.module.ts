import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeuserComponent } from './componenteLoguin/componenteUsuario/homeuser/homeuser.component';
import { RegistratiendaComponent } from './componenteLoguin/componenteUsuario/registratienda/registratienda.component';
import { MitiendaComponent } from './componenteLoguin/componenteAdministrador/mitienda/mitienda.component';
import { HomeComponent } from './componente/home/home.component';
import { TiendasuserComponent } from './componenteLoguin/componenteUsuario/tiendasuser/tiendasuser.component';
import { PedidosuserComponent } from './componenteLoguin/componenteUsuario/pedidosuser/pedidosuser.component';
import { HeaderuserComponent } from './componenteLoguin/componenteUsuario/headeruser/headeruser.component';
import { TiendasadminComponent } from './componenteLoguin/componenteAdministrador/tiendasadmin/tiendasadmin.component';
import { HomeadminComponent } from './componenteLoguin/componenteAdministrador/homeadmin/homeadmin.component';
import { HeaderadminComponent } from './componenteLoguin/componenteAdministrador/headeradmin/headeradmin.component';
import { PedidosadminComponent } from './componenteLoguin/componenteAdministrador/pedidosadmin/pedidosadmin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeuserComponent,
    RegistratiendaComponent,
    MitiendaComponent,
    HomeComponent,
    TiendasuserComponent,
    PedidosuserComponent,
    HeaderuserComponent,
    TiendasadminComponent,
    HomeadminComponent,
    HeaderadminComponent,
    PedidosadminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
