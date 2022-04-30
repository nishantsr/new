import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { SecurityService } from 'src/app/services/security.service';
import { CUser } from 'src/app/utilities/cuser';

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
  constructor(private loginService: LoginService, private router:Router, private SecurityService: SecurityService) { 
    
  }
  loginForm= new FormGroup({
    email: new FormControl('', Validators.email),
    password: new FormControl('', Validators.required),
    // captcha: new FormControl('', Validators.requiredTrue)
  })
  ngOnInit(): void {
  }

  public resolved(captchaResponse: string) { 
    console.log(`Resolved captcha with response: ${captchaResponse}`); // Write your logic here about once human verified what action you want to perform 
    }

    
    message:any;
  formSubmit()
  {
    
    if((this.user.emailId!='' && this.user.password!='')&&(this.user.emailId!=null && this.user.password!= null))
    {
      this.loginService.generateToken(this.user).subscribe(
        (response)=>{
          console.log("Token: "+response);
          this.loginService.loginUser(response);
          let token= localStorage.getItem('token')
          this.User.emailId= this.user.emailId;
          this.loginService.findByEmail(this.User, token).subscribe(
            (response)=>{
              console.log(response)
              sessionStorage.setItem('user',JSON.stringify(response));
            },
            (error)=>{console.log(error)}
          )
          if(this.user.emailId=="nishant@gmail.com"){
            window.location.href="/admin "
          }else{
            window.location.href="/dashboard"
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

}
