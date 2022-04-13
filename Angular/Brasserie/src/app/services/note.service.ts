import { HttpClient } from '@angular/common/http';
import { Injectable, TestabilityRegistry } from '@angular/core';
import { Observable } from 'rxjs';
import { Biere } from '../model/biere';
import { Note } from '../model/note';

@Injectable({
  providedIn: 'root',
})
export class NoteService {
  private static url: string = 'http://localhost:8080/brasserie/api/note';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(NoteService.url);
  }

  public getById(id: number): Observable<any> {
    return this.http.get<any>(`${NoteService.url}/${id}`);
  }

  public getByClient(id: number): Observable<any> {
    return this.http.get<any>(NoteService.url + '/' + id + '/byClient');
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${NoteService.url}/${id}`);
  }

  public noteToJson(note: Note): any {
    let n = {
      id_note: note.id_note,
      client: { id: note.id_client?.id },
      biere: { nom: note.biere?.nom, type: 'biere', id: note.biere?.id },
      note: note.note,
      commentaire: note.commentaire,
    };
    return n;
  }

  public create(note: Note): Observable<any> {
    return this.http.post(NoteService.url, this.noteToJson(note));
  }

  public update(note: Note): Observable<any> {
    console.log(this.noteToJson(note));
    return this.http.put(
      `${NoteService.url}/${note.id_note}`,
      this.noteToJson(note)
    );
  }

  public getMoyenne(biere: Biere): Observable<number[]> {
    return this.http.get<number[]>(
      NoteService.url + '/' + biere.id + '/moyenne'
    );
  }
}
