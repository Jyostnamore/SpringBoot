import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  url="http://localhost:8080"
  constructor(private http:HttpClient) { }
//calling serevr to genrate token
genrateToken(credentials:any)
{
  //token genrate
  return this.http.post(`${this.url}/token`,credentials)
}
  loginUser(token:any)
  {
    localStorage.setItem("token",token)
    return true;
  }
  idLoggedIn()
  {
    let token=localStorage.getItem("token")
    if(token==undefined||token===''||token==null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  //for logout the user
  logout()
  {
    localStorage.removeItem('token')
    return true;
  }
  //for get token
  getToken()
  {
    return localStorage.getItem("token");
  }
}
