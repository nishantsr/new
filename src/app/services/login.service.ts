import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private _http: HttpClient,
    private router: Router
    ) { }
  public login1(user:any){
    return this._http.post(`http://localhost:8091/login`,user);
    }


  generateToken(user:any)
  {
    return this._http.post(`http://localhost:9093/authenticate`,user,{responseType: 'text' as 'json'});
  }  
  public loginUser(token:any)
  {
    localStorage.setItem("token",token);
  }

  isLoggedIn()
  {
    let token= localStorage.getItem("token");
    if(token==undefined || token==='' || token== null){
      return false;
    }else{
      return true;
    }
  }

  logout(){
    localStorage.removeItem('token')
    localStorage.removeItem('loginEmail');
    localStorage.removeItem('userObject');
    this.router.navigate(['/login']);
    return true;
  }

  //for getting the token
  getToken()
  {
    return localStorage.getItem('token');
  }

 findByEmail(User:any, token:any)
 {
  let tokenStr= 'Bearer '+token
  const headers= new HttpHeaders().set("Authorization", tokenStr);
  return this._http.post(`http://localhost:9093/user/fetchByEmail`,User,{headers, responseType: 'text' as 'json'});
 }



}
