import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError, map, tap } from 'rxjs/operators';
import { Lobster } from './lobster.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Lobster Data';
  lobsters:  Lobster[]= [];
  

  constructor(private http: HttpClient){}
  
  httpOptions = {
    headers: new HttpHeaders({      
      'Authorization': 'Basic ' + btoa('user:password')
    })
  };
  
  ngOnInit(): void {
    this.getLobsters().subscribe(
      response => {
        this.lobsters = [...response];
      }
    )
  }

  editLobster(name:string) : void{
    //need to implement
  }

  //deleteLobster(id: number){
    /*if(confirm("Are you sure to delete lobster?")) {
      this.lobsters.forEach(function(item, index, object) {
        if (item.id === id) {
          object.splice(index, 1);
        }
      });      
    }*/
  //}

  deleteLobster(id: number) {
    console.log('delete lobster called');
    this.deleteLobsterData(id).subscribe();
  }

  getLobsters(): Observable<Lobster[]> {
    return this.http.get<Lobster[]>('http://localhost:9090/lobster')
  }

  /** DELETE: delete the hero from the server */
  deleteLobsterData(id: number): Observable<unknown> {
  const url = 'http://localhost:9090/lobster/'+id; // DELETE api/heroes/42
  return this.http.delete(url, this.httpOptions).pipe();
}


}
