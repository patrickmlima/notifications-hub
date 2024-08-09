import { CategoryViewDto } from './categories.type';
import { NotificationChannelViewDto } from './notification-channel.type';
import { UserViewDto } from './user.type';

export type MessageDispatch = {
  messageId: number;
  userId: number;
  channelId: number;
  createdAt: Date;
  deliveredAt: Date;
};

export type MessageDispatchViewDto = Pick<
  MessageDispatch,
  'createdAt' | 'deliveredAt'
> & {
  user: UserViewDto;
  channel: NotificationChannelViewDto;
};
