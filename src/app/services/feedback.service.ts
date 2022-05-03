import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private httpClient:HttpClient) {}

   addFeedback(feedback:any):Observable<Object>{
    console.log(feedback);
    return this.httpClient.post(`http://localhost:9090/addFeedback`,feedback);
  }
}
