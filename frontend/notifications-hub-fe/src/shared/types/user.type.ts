import { SimpleIdEntity } from './common.type';

export type User = SimpleIdEntity<number> & {
  name: string;
  email: string;
  phoneNumber: string;
  createdAt: Date;
  updatedAt: Date;
};

export type UserViewDto = Pick<User, 'id' | 'name'>;
