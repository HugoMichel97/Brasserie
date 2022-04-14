import { Biere } from './../model/biere';
import { Achat } from './../model/achat';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AchatService {
  private static url: string = 'http://localhost:8080/brasserie/api/achat';
  private static urlClient: string =
    'http://localhost:8080/brasserie/api/client';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(AchatService.url);
  }

  public getById(id: number): Observable<any> {
    return this.http.get<any>(`${AchatService.url}/${id}`);
  }

  public getByClient(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      AchatService.urlClient + '/' + id + '/getAchat'
    );
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${AchatService.url}/${id}`);
  }

  public achatToJson(achat: Achat): any {
    let a = {
      id_achat: achat.id_achat,
      id_client: { id: achat.id_client?.id },
      id_produit: { id: achat.id_produit?.id },
      quantite: achat.quantite,
    };
    if (achat.id_produit instanceof Biere) {
      Object.assign(a, {
        id_produit: { type: 'biere', id: achat.id_produit?.id },
      });
    } else {
      Object.assign(a, {
        id_produit: { type: 'snack', id: achat.id_produit?.id },
      });
    }
    return a;
  }

  public create(achat: Achat): Observable<any> {
    return this.http.post(AchatService.url, this.achatToJson(achat));
  }

  public createCatalogue(achat: Achat): Observable<any> {
    return this.http.post(AchatService.url, achat);
  }

  public update(achat: Achat): Observable<any> {
    console.log(this.achatToJson(achat));
    return this.http.put(
      `${AchatService.url}/${achat.id_achat}`,
      this.achatToJson(achat)
    );
  }
}
