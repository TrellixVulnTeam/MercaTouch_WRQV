import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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

const routes: Routes = [{
  path: 'home',
  component: HomeComponent
},
{
  path: 'homeuser',
  component: HomeuserComponent
},
{
  path: 'tiendasuser',
  component: TiendasuserComponent
},
{
  path: 'pedidosuser',
  component: PedidosuserComponent
},
{
  path: 'headeruser',
  component: HeaderuserComponent
},
{
  path: 'registratienda',
  component: RegistratiendaComponent
},
{
  path: 'homeadmin',
  component: HomeadminComponent
},
{
  path: 'headeradmin',
  component: HeaderadminComponent
},
{
  path: 'pedidosadmin',
  component: PedidosadminComponent
},
{
  path: 'tiendasadmin',
  component: TiendasadminComponent
},
{
  path: 'mitienda',
  component: MitiendaComponent
},
{
  path: '**',
  redirectTo: 'home'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
