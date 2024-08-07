import { environment } from '../../environments/environment';
import { Message } from '../types/message.type';
import { ResourceApiRepository } from './resource-api-repository';

export class MessageRepository extends ResourceApiRepository<Message> {
  constructor() {
    super(environment.API_URL, '/messages');
  }
}
