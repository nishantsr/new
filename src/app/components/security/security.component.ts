import { Component, OnInit } from '@angular/core';

import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {
  // authRequest:any={
  //   "emailId": "nishant1@gmail.com",
  //   "password": "admin"
  // };
  // response:any
  constructor(private service: SecurityService) { 
   
  }

  ngOnInit(): void {
    // this.getAccessToken(this.authRequest);
  }

  // public getAccessToken(authRequest:any){
  //   let resp= this.service.generateToken(authRequest);
  //   resp.subscribe(data=>{
  //     console.log("Token ="+data)
  //     // localStorage.setItem("token", JSON.stringify(data));
  //     this.accessApi(data)
  //   });
  // }

  // public accessApi(token:any)
  // {
  //   let resp= this.service.welcome(token);
  //   resp.subscribe(data=>this.response=data)
  // }

}
