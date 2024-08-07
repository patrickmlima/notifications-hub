import { Injectable } from '@angular/core';
import { ResourceApiRepository } from '../../shared/repositories/resource-api-repository';
import { environment } from '../../environments/environment';
import { Message } from '../../shared/types/message.type';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class MessageService extends ResourceApiRepository<Message> {
  constructor(private httpClient: HttpClient) {
    super(environment.API_URL, '/messages', httpClient);
  }
}
