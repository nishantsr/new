import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(private http: HttpClient) { }

  public generateToken(request:any){
    return this.http.post("http://localhost:8091/authenticate",request,{responseType: 'text' as 'json'});
  }

  public welcome(token:any)
  {
    let tokenStr= 'Bearer '+token
    const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get("http://localhost:8091/welcome", {headers,responseType: 'text' as 'json'});
  }

  public login(user:any, token:any){
    let tokenStr= 'Bearer '+token
    const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post(`http://localhost:8091/login`,user, {headers,responseType: 'text' as 'json'});
    }

  public addUser(user:any, token:any){
    let tokenStr= 'Bearer '+token
  const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post(`http://localhost:8091/register`, user, {headers,responseType: 'text' as 'json'});
    }

  public getUsers(token:any)
  {
    let tokenStr= 'Bearer '+token
    const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get(`http://localhost:8091/user/getUsers`,{headers});
  }

  public updateUser(user:any, token:any)
  {
    let tokenStr= 'Bearer '+token
    const headers= new HttpHeaders().set("Authorization", tokenStr);
    return this.http.put(`http://localhost:8091/user/updateUser`, user, {headers})
  }
}
