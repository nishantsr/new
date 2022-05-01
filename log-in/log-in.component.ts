import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/utilities/user';
import { OtpService } from 'src/app/services/otp.service';



@Component({
  selector: 'app-LogIn',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  user=new User();
  loading!:false;
  otpCred:any={
    "contact":"",
    "otp":""
  };
  flag=false;
  message!:string;
  responseOtp:boolean=false;
  captcha:boolean=false;

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private _userService:UserService,
      private _otpService:OtpService) { }

  ngOnInit() {

  }
  public resolved(captchaResponse: string) {
    console.log(`Resolved captcha with response: ${captchaResponse}`); 
      this.captcha=true;
    }

  login() {
      this._userService.loginUser(this.user).subscribe(data=>{
        if(this.user.email==="neeraj@gmail.com"){

          localStorage.setItem("admin",JSON.stringify(data));
          this.router.navigate(['home/login/adminHome/flightList']);
        }else {
          localStorage.setItem("user",JSON.stringify(data));
          this.user=JSON.parse(localStorage.getItem("user") || '{}');
          console.log(this.user);
          this.sendOtp(this.user.contact);
          //
        }
      },error=>console.log("error occured!!!")
      )
      
  }
  verifyOtp(){
    this._otpService.verifyOtp(this.otpCred).subscribe(response=>{
      
      console.log(response)
      if(response===true){
        this.message="Otp verified succesfully!!!";
        this.responseOtp=response;
        this.router.navigate(['home/login/userHome/userSearch']);
      }
    },error=>{
      this.message="Invalid otp!!!!!";
    })
  }

  sendOtp(contact:any){
    this.otpCred.contact="+91"+contact;
    this._otpService.sendOtp(this.otpCred.contact).subscribe(response=>{
        if(response===false){
          this.flag=true;
          this.message="Otp sent to =>+91"+this.otpCred.contact;
        }
    },error=>{
      this.message="Cannot send otp..."
    })
  }

  signUp(){
    this.router.navigate(['home/login/register']);
  }

}