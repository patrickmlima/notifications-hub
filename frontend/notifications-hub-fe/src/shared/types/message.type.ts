import { Category } from './categories.type';
import { SimpleIdEntity } from './common.type';

export type Message = SimpleIdEntity<number> & {
  body: string;
  createdAt: Date;
  deliveredAt: Date;
  category: Category;
};

export type MessageCreateDto = {
  body: string;
  categoryId: number;
};
