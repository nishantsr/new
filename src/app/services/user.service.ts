import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  public getUsers()
  {
    return this.http.get(`http://localhost:8091/user/getUsers`)
  }

  public updateUser(user:any)
  {
    return this.http.put(`http://localhost:8091/user/updateUser`, user)
  }

  public getUsers2(token:any)
  {
    let tokenStr= 'Bearer '+token
    const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get(`http://localhost:8091/user/getUsers`, {headers})
  }

  
}
