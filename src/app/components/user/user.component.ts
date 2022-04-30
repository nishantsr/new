import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SecurityService } from 'src/app/services/security.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public detailsToUpdate= {
    username:'',
    firstName:'',
    lastName:'',
    emailId:'',
    mobile:''
  }

  updateForm= new FormGroup(
    {
      username: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('',Validators.required),
      emailId: new FormControl('', Validators.required),
      mobile: new FormControl('', Validators.required)
  }
    
  )
  userList:any= [];
  constructor(private list: UserService, private Service: SecurityService) {
    // this.getUsers();
   }

   token:any= JSON.parse(sessionStorage.getItem('token')||'{}');
  ngOnInit(): void {
    this.getUsers();
  }
  edit(user: any)
  {
    this.detailsToUpdate= user;
  }
  formUpdate(){
    this.Service.updateUser(this.detailsToUpdate,this.token).subscribe((data:any)=>{
      console.log("User updated successfully");
      alert('Sucess');
    })
  }
  // getUsers(){
  //   this.list.getUsers().subscribe(
  //     (resp)=>{
  //       console.log(resp);
  //       this.userList= resp;
  //     },(err)=>{
  //       console.log(err)
  //     });
  // }
  getUsers(){
    this.Service.getUsers(this.token).subscribe(
      (resp)=>{
        console.log(resp);
        this.userList= resp;
    }, (error)=>{
      console.log(error);
    })
  }
}
