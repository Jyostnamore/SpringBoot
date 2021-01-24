import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from 'src/app/loginService/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }
  constructor(private loginser:LoginserviceService) { }

  ngOnInit(): void {
  }
  onSubmit()
  {
   
    if((this.credentials.username!='' && this.credentials.password!='')&& (this.credentials.username!=null&& this.credentials.password!=null))
    {
      console.log("submit");

      //token genrate
      this.loginser.genrateToken(this.credentials).subscribe((response:any)=>{
        //successs
        console.log(response.token);

        this.loginser.loginUser(response.token)
        window.location.href="/employees"
      },
    error =>{
      //error
      console.log(error)}
      
      
      
      
      );
    }
    else{
      console.log("fileds are empty");
    }
  }
}
