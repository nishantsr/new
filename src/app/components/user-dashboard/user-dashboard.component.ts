import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private userService: UserService, private loginService: LoginService) { }
  public email={
    emailId: JSON.stringify(localStorage.getItem('loginEmail'))
  }
  ngOnInit(): void {
  }
 token= localStorage.getItem('token');
 
  getUser(){
    
    this.userService.getUsers2(this.token).subscribe(
      (user)=>console.log(user),
      (error)=>console.log(error)
    )
  }

}
