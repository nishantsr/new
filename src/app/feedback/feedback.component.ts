import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  feed= {
    userId:'',
	  feedbackDetails:'',
	  rating: 1
  }

  constructor(private service: FeedbackService, private router: Router) { }

  ngOnInit(): void {
    let str=JSON.parse(localStorage.getItem('userObject')||'{}');
    var obj= JSON.parse(str);
    console.log(obj.userId);
    console.log(obj);
    this.feed.userId= obj.userId;
  }

  addFeedback(){
    //console.log(this.feedback.value);
    this.service.addFeedback(this.feed).subscribe(data=>{
      alert("Feedback added successfully...")
      //this.feedback.reset()
      this.router.navigate(['dashboard'])
    },
    error=>alert("Feedback not added..."),
    //this.feedback.reset()
    );
  }
}
