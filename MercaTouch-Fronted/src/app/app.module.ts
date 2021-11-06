import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './componente/home/home.component';
import { HeaderComponent } from './ComponenteLogin/header/header.component';
import { TiendasComponent } from './ComponenteLogin/tiendas/tiendas.component';
import { PedidosComponent } from './ComponenteLogin/pedidos/pedidos.component';
import { HomeuserComponent } from './ComponenteLogin/homeuser/homeuser.component';
import { MitiendaComponent } from './ComponenteLogin/mitienda/mitienda.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    TiendasComponent,
    PedidosComponent,
    HomeuserComponent,
    MitiendaComponent
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
