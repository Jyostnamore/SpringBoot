import { componentFactoryName } from '@angular/compiler';
import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';
import { DashboardComponent } from './loginComponent/dashboard/dashboard.component';
import { HomeComponent } from './loginComponent/home/home.component';
import { LoginComponent } from './loginComponent/login/login.component';
import { ManagerComponent } from './manager/manager.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';



const routes: Routes = [
  {path :'employees', component:EmployeeListComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},
  // {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'update-employee/:id', component: UpdateEmployeeComponent},
  {path:'create-manager',component:ManagerComponent},
  {path: 'employee-details/:id', component: EmployeeViewComponent},
  {path :'', component:HomeComponent,pathMatch:'full'},
  {path:"login", component:LoginComponent},
  {path:"dashboard", component:DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
