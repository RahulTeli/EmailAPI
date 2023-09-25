import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailservService {
  private baseUrl :string = "http://localhost:8080"
  constructor(private http : HttpClient) { } // creating HttpClient object

  sendMail(data:any)
  {
   return this.http.post(`${this.baseUrl}/sendmail`,data) //sending request with data to backend at '/sendemail' path 
    //sendemail is request path present inside backend
  }
}
