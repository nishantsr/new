import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AdminComponent } from './components/admin/admin.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserComponent } from './components/user/user.component';

const routes: Routes = [
{
  path:'login', 
  component: LoginComponent,
  children: [{ path: 'registration', component: UserComponent }]
},
{path:'registration', component: RegisterComponent},
{path:'dashboard', component: UserDashboardComponent, canActivate: [AuthGuard]},
{path:'admin', component: AdminComponent, canActivate: [AuthGuard]},
{path:'user', component: UserComponent},
{path:'userList', component: UserListComponent, canActivate: [AuthGuard]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
