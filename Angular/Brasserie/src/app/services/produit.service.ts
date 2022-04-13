import { Biere } from './../model/biere';
import { Produit } from './../model/produit';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  private static url: string = 'http://localhost:8080/brasserie/api/produit';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(ProduitService.url);
  }

  public getById(id: number): Observable<any> {
    return this.http.get<any>(`${ProduitService.url}/${id}`);
  }

  public getAllBeers(): Observable<any[]> {
    return this.http.get<any[]>(ProduitService.url + '/biere');
  }

  public getAllSnacks(): Observable<any[]> {
    return this.http.get<any[]>(ProduitService.url + '/snack');
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ProduitService.url}/${id}`);
  }

  private produitToJson(produit: Produit): any {
    let p = {
      id: produit.id,
      nom: produit.nom,
      description: produit.description,
      prix: produit.prix,
      stock: produit.stock,
      points: produit.points,
    };
    if (produit instanceof Biere) {
      Object.assign(p, {
        type: 'biere',
      });
    } else {
      Object.assign(p, {
        type: 'snack',
      });
    }
    return p;
  }

  public create(produit: Produit): Observable<any> {
    return this.http.post(ProduitService.url, this.produitToJson(produit));
  }

  public update(produit: Produit): Observable<any> {
    console.log(this.produitToJson(produit));
    return this.http.put(
      `${ProduitService.url}/${produit.id}`,
      this.produitToJson(produit)
    );
  }
}
