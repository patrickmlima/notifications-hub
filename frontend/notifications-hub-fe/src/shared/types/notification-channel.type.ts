import { SimpleIdEntity } from './common.type';

export type NotificationChannel = SimpleIdEntity<number> & {
  name: string;
  createdAt: Date;
  updatedAt: Date;
};

export type NotificationChannelViewDto = Pick<
  NotificationChannel,
  'id' | 'name'
>;
