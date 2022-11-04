import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  OPTIONS_JSON = {
    HEADERS: new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    })
  }
  

  constructor(private httpClient:HttpClient) { }

  public loginAdminFromRest(admin:Admin):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/admin/login",admin);
  }

  public registerAdminRest(admin: Admin):Observable<any> {
    return this.httpClient.post<any>("http://localhost:8080/admin/register",admin); 
  }
}
