import { Observable } from 'rxjs';

export interface ApiRepository<T, PK> {
  getAll(): Observable<T[]>;
  getOne(id: PK): Observable<T>;
  create(data: Partial<T>): Observable<T>;
  update(id: PK, data: Partial<T>): Observable<T>;
  delete(id: PK): Observable<unknown>;
}
