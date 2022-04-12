import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor(private http: HttpClient) {}

  public authentication(mail: string, password: string): Observable<any> {
    let httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(mail + ':' + password),
    });

    return this.http.get<any>('http://localhost:8080/brasserie/api/auth', {
      headers: httpHeaders,
      responseType: 'text' as 'json',
    });
  }

  isAutenticated(): boolean {
    return localStorage.getItem('login') ? true : false; // ?
  }
}
