import { Component, OnInit } from '@angular/core';
import { SecurityService } from 'src/app/services/security.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  userList:any= [];
  constructor(private list: UserService, private service: SecurityService) { 
    this.getUsers();
  }

  ngOnInit(): void {
  }
  token:any= JSON.parse(sessionStorage.getItem("token")||'{}')
  getUsers(){
    this.service.getUsers(this.token).subscribe(
      (resp)=>{
        console.log(resp);
        this.userList= resp;
      },(err)=>{
        console.log(err)
      });
  }
}
