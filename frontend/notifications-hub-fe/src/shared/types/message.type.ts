import { Category, CategoryViewDto } from './categories.type';
import { SimpleIdEntity } from './common.type';
import {
  MessageDispatch,
  MessageDispatchViewDto,
} from './message-dispatch.type';

export type Message = SimpleIdEntity<number> & {
  body: string;
  createdAt: Date;
  category: Category;
  messageDispatches: MessageDispatch[];
};

export type MessageCreateDto = {
  body: string;
  categoryId: number;
};

export type MessageViewDto = Pick<Message, 'id' | 'body' | 'createdAt'> & {
  category: CategoryViewDto;
  messageDispatches: MessageDispatchViewDto[];
};
