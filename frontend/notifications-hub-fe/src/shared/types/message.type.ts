import { SimpleIdEntity } from './common.type';

export type Message = SimpleIdEntity<number> & {
  body: string;
  createdAt: Date;
  deliveredAt: Date;
};
