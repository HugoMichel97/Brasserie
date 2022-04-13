import { Brasseur } from './../model/brasseur';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BrasseurService {
  private static URL: string = 'http://localhost:8080/brasserie/api/brasseur';

  constructor(private http: HttpClient) {}

  public get(id: number): Observable<Brasseur> {
    return this.http.get<Brasseur>(`${BrasseurService.URL}/${id}`);
  }

  public update(brasseur: Brasseur): Observable<any> {
    return this.http.patch(
      BrasseurService.URL + '/' + brasseur.id,
      this.brasseurToJson(brasseur)
    );
  }

  // public updatePassword(
  //   brasseur: Brasseur,
  //   value: string
  // ): Observable<Brasseur> {
  //   return this.http.patch<Brasseur>(BrasseurService.URL + '/' + brasseur.id, {
  //     password: value,
  //   });
  // }

  private brasseurToJson(brasseur: Brasseur): any {
    let obj = {
      mail: brasseur.mail,
      depenses: brasseur.depenses,
      recettes: brasseur.recettes,
      tresorerie: brasseur.tresorerie,
    };
    return obj;
  }
}
