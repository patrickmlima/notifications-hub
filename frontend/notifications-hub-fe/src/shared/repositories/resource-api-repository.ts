import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiRepository } from '../interfaces/api-respository';
import { inject } from '@angular/core';

export class ResourceApiRepository<R> implements ApiRepository<R, number> {
  private http: HttpClient = inject(HttpClient);
  private resourceUrl: string;

  constructor(serverUrl: string, resourceUri: string) {
    this.resourceUrl = `${serverUrl}/${resourceUri}`;
  }

  getAll(): Observable<R[]> {
    this.http;
    return this.http.get<R[]>(this.resourceUrl);
  }
  getOne(id: number): Observable<R> {
    const url = `${this.resourceUrl}/${id}`;
    return this.http.get<R>(url);
  }
  create(data: Partial<R>): Observable<R> {
    return this.http.post<R>(this.resourceUrl, data);
  }
  update(id: number, data: Partial<R>): Observable<R> {
    const url = `${this.resourceUrl}/${id}`;
    return this.http.put<R>(this.resourceUrl, data);
  }
  delete(id: number): Observable<unknown> {
    const url = `${this.resourceUrl}/${id}`;
    return this.http.delete(this.resourceUrl);
  }
}
