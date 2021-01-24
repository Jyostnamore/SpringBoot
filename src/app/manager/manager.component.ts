import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from '../manager';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
manager:Manager=new Manager();
  constructor(private managerser:ManagerserviceService,
    private router:Router) { }
    saveEmployee()
    {
      this.managerser.createEmployee(this.manager).subscribe(data =>{
        console.log(data);
        
      },
      error=>console.log(error));
     
    }
  ngOnInit(): void {
  }
 onSubmit()
 {
  console.log(this.manager);
  this.saveEmployee();
 }
}
