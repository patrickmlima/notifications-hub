import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { ResourceApiRepository } from '../../shared/repositories/resource-api-repository';
import { Message } from '../../shared/types/message.type';

@Injectable({ providedIn: 'root' })
export class MessageService extends ResourceApiRepository<Message> {
  constructor() {
    super(environment.API_URL, 'messages');
  }
}
