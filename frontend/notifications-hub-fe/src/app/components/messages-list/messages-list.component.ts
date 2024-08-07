import { Component, OnInit, signal } from '@angular/core';
import { MessageService } from '../../services/messages.service';
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
  constructor(private readonly messageService: MessageService) {}

  messagesList = signal<Message[]>([]);

  ngOnInit(): void {
    this.messageService.getAll().subscribe((data) => {
      this.messagesList.set(data);
    });
  }
}
