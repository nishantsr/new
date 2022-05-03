import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  public detailsToUpdate= {
    userId: '',
    username:'',
    firstName:'',
    lastName:'',
    emailId:'',
    mobile:'',
    role: ''
  }

  updateForm= new FormGroup(
    {
      username: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('',Validators.required),
      emailId: new FormControl('', Validators.required),
      mobile: new FormControl('', Validators.required)
  })

  constructor(private Service: SecurityService) { }
  token:any= localStorage.getItem('token');
  ngOnInit(): void {
    let str =  JSON.parse(localStorage.getItem('userObject')||'{}');
    let obj = JSON.parse(str);
    console.log(obj);
    this.detailsToUpdate.userId= obj.userId;
    this.detailsToUpdate.username= obj.username;
    this.detailsToUpdate.firstName= obj.firstName;
    this.detailsToUpdate.lastName= obj.lastName;
    this.detailsToUpdate.emailId= obj.emailId;
    this.detailsToUpdate.mobile= obj.mobile;
    this.detailsToUpdate.role= obj.role;
  }

  formUpdate(){
   
    this.Service.updateUser(this.detailsToUpdate,this.token).subscribe(
      (response)=>{console.log(response)},
      (error)=>{console.log(error)}
    )
    if(this.detailsToUpdate.emailId=="nitesh@cybage.com"){
      window.location.href="/admin "
    }else{
      window.location.href="/dashboard"
    }
  }
}
