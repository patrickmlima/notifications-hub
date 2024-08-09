import { Component, inject, OnInit, signal } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { Message } from '../../../shared/types/message.type';
import { CommonModule } from '@angular/common';
import { NewMessageComponent } from '../new-message/new-message.component';
import { MessageDetailsComponent } from '../message-details/message-details.component';

@Component({
  selector: 'app-messages-list',
  standalone: true,
  imports: [CommonModule, NewMessageComponent, MessageDetailsComponent],
  templateUrl: './messages-list.component.html',
  styleUrl: './messages-list.component.css',
  providers: [MessageService],
})
export class MessagesListComponent implements OnInit {
  private messageService = inject(MessageService);

  messagesList = signal<Message[]>([]);

  constructor() {}

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages() {
    this.messageService.getAll().subscribe((data: Message[]) => {
      this.messagesList.set(data);
    });
  }
}
