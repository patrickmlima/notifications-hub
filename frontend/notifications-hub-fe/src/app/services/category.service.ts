import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { ResourceApiRepository } from '../../shared/repositories/resource-api-repository';
import { Category } from '../../shared/types/categories.type';

@Injectable({ providedIn: 'root' })
export class CategoryService extends ResourceApiRepository<Category> {
  constructor() {
    super(environment.API_URL, 'categories');
  }
}
