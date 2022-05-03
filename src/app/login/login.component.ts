import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

import { CUser } from '../utilities/cuser';


//import { CUser } from 'src/app/utilities/cuser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userObj= new CUser();
  public user={
    emailId:'',
    password: ''
    };
  public User={
    userId: '',
    username: '',
    firstName: '',
    lastName: '',
    password: '',
    emailId: '',
    mobile: '',
    
  }
  captcha:boolean= false;
  flag=false;
  responseOtp:boolean=false;
  constructor(
    private loginService: LoginService, 
    private router:Router, 
    
    
    ) { 
    
  }
  loginForm= new FormGroup({
    email: new FormControl('', Validators.email),
    password: new FormControl('', Validators.required)
  })
  ngOnInit(): void {
  }

  // public resolved(captchaResponse: string) { 
  //   console.log(`Resolved captcha with response: ${captchaResponse}`); // Write your logic here about once human verified what action you want to perform 
  //   this.captcha=true;
    
  //   }

    
  message:any;
  formSubmit()
  {
    
    if((this.user.emailId!='' && this.user.password!='')&&(this.user.emailId!=null && this.user.password!= null))
    {
      this.loginService.generateToken(this.user).subscribe(
        (response)=>{
          console.log("Token: "+response);

          //Storing token in local storage, method written in login service.
          this.loginService.loginUser(response);
          let token= localStorage.getItem('token')

          //Retreiving input emailId and storing into declared object emailId.
          this.User.emailId= this.user.emailId;

          //Fetching Logged in user object from server side right after getting token.
          this.loginService.findByEmail(this.User, token).subscribe(
            (response)=>{
              console.log(response)
              //Setting the logged in user object into local storage so that we can use it later.
              localStorage.setItem('userObject',JSON.stringify(response));
              
            },
            (error)=>{console.log(error)}
          )
          if(this.user.emailId=="thenishantsrivastava@gmail.com"){
            this.userObj= JSON.parse(localStorage.getItem('userObject')||'{}');
            console.log(this.userObj);
          
        this.router.navigate(['/admin'])
            
          }else{
            window.location.href="/home"
          }
          },
        (error)=>{
          console.log(error)
        }
      )
    }else{
      console.log("Fields are empty");
      alert("Invalid data");
    }
   
    
    // this.SecurityService.generateToken(this.user).subscribe((data:any)=>{
    //   console.log("Token: "+data);
    //   sessionStorage.setItem("token", JSON.stringify(data));
    //   if(this.user.emailId=="majid@cybage.com"){
    //     this.router.navigate(['/admin']);
    //   }else{
    //     this.router.navigate(['/user']);
    //   }
    //   alert('success');
    // },(err)=>{
    //   console.log("Invalid Credentials")
    //   this.message="Invalid Credentials";
    // })
    
    
  }
  me()
  {
    this.user= JSON.parse(localStorage.getItem('userObject')||'{}')
    sessionStorage.setItem('details', JSON.stringify(this.user));
   
  }
 
   

}
