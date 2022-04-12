import { Reservation } from './../model/reservation';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private static URL: string = 'http://localhost:8080/brasserie/api/reservation';

    constructor(private http: HttpClient) {}

    public getAll(): Observable<Reservation[]> {
      return this.http.get<Reservation[]>(ReservationService.URL);
    }

    public delete(id: number): Observable<void> {
      return this.http.delete<void>(ReservationService.URL + '/' + id);
    }

    public get(id: number): Observable<Reservation> {
      return this.http.get<Reservation>(ReservationService.URL + '/' + id);
    }
    public getWithClient(id: number): Observable<Reservation[]> {
      return this.http.get<Reservation[]>('http://localhost:8080/brasserie/api/client/' +id + '/getResa' );
    }
    public create(reservation: Reservation): Observable<Reservation> {
      let obj = {
        client: reservation.client,
        evt : reservation.evt,
      };
      console.log(reservation);
      console.log(obj);
      return this.http.post<Reservation>(ReservationService.URL, obj);
    }

    public update(reservation: Reservation): Observable<Reservation> {
      console.log(reservation);
      return this.http.put<Reservation>(
        ReservationService.URL + '/' + reservation.id,
        reservation
      );
    }
}
