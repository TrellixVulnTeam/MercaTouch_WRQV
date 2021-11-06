import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './componente/home/home.component';
import { HeaderComponent } from './ComponenteLogin/header/header.component';
import { TiendasComponent } from './ComponenteLogin/tiendas/tiendas.component';
import { PedidosComponent } from './ComponenteLogin/pedidos/pedidos.component';
import { HomeuserComponent } from './ComponenteLogin/homeuser/homeuser.component';
import { MitiendaComponent } from './ComponenteLogin/mitienda/mitienda.component';

const routes: Routes = [{
  path: 'home',
  component: HomeComponent
},
{
  path: 'homeuser',
  component: HomeuserComponent
},
{
  path: 'header',
  component: HeaderComponent
},
{
  path: 'tiendas',
  component: TiendasComponent
},
{
  path: 'pedidos',
  component: PedidosComponent
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
