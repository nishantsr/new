import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';
import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public user={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    emailId:'',
    mobile:''
    // role:''
  };
  registrationForm=new FormGroup(
    {
     firstName: new FormControl('', Validators.required),
     lastName: new FormControl('', Validators.required),
     emailId: new FormControl('', Validators.email),
     username: new FormControl('', Validators.required),
     password: new FormControl('', Validators.required),
     mobile: new FormControl('', Validators.required)
    //  role: new FormControl('passenger', Validators.required)
  }
  );
  constructor(private userService: RegisterService, private service: SecurityService,private router:Router) { }
  // token:any= JSON.parse(localStorage.getItem("token")||'{}');
  token:any=""
  ngOnInit(): void {
    
  }

  formSubmit()
  {
    this.service.addUser(this.user,this.token).subscribe((data:any)=>{
      //success
      
      console.log(data);
      this.router.navigate(['/dashboard']);
      console.log("User added successfully");
      alert('Sucess');
    },
    //error
    (error)=>{
      console.log("Error while adding User");
      alert("Something went wrong..!");
    }
    )
  };

}
