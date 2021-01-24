import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Manager } from './manager';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ManagerserviceService {
  private baseURL = "http://localhost:8080/api/v2/manager";
  
  constructor(private httpClient: HttpClient) { }
  createEmployee(employee:Manager):Observable<object>
  {
    return this.httpClient.post(`${this.baseURL}`,employee);
  }
}
