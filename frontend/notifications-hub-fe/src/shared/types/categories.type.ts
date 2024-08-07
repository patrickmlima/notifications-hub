import { SimpleIdEntity } from './common.type';

export type Category = SimpleIdEntity<number> & {
  name: string;
  createdAt: Date;
  updatedAt: Date;
};
