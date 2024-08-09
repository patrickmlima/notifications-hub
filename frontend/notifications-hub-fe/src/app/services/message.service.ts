import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { ResourceApiRepository } from '../../shared/repositories/resource-api-repository';
import { Message, MessageViewDto } from '../../shared/types/message.type';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class MessageService extends ResourceApiRepository<Message> {
  constructor() {
    super(environment.API_URL, 'messages');
  }

  public getDetails(id: number): Observable<MessageViewDto> {
    return this.getHttpClient().get<MessageViewDto>(
      `${this.getResourceUrl()}/${id}`
    );
  }
}
