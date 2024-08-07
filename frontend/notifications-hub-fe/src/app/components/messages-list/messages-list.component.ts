import { Component, inject, OnInit, signal } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { Message } from '../../../shared/types/message.type';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-messages-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './messages-list.component.html',
  styleUrl: './messages-list.component.css',
  providers: [MessageService],
})
export class MessagesListComponent implements OnInit {
  private messageService = inject(MessageService);
  constructor() {}

  messagesList = signal<Message[]>([]);

  ngOnInit(): void {
    this.messageService.getAll().subscribe((data: Message[]) => {
      this.messagesList.set(data);
    });
  }
}
