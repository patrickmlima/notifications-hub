import { Component, inject, Input, signal, TemplateRef } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Message, MessageViewDto } from '../../../shared/types/message.type';

@Component({
  selector: 'app-message-details',
  standalone: true,
  imports: [],
  templateUrl: './message-details.component.html',
  styleUrl: './message-details.component.css',
})
export class MessageDetailsComponent {
  @Input() messageId: number | undefined;

  private modalService = inject(NgbModal);
  private modalRef: NgbModalRef | undefined;

  message = signal<MessageViewDto | undefined>(undefined);

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {}

  open(content: TemplateRef<any>) {
    this.modalRef = this.modalService.open(content, { fullscreen: true });
    if (this.messageId) {
      this.loadMessageDetails(this.messageId);
    }
  }

  close() {
    if (this.modalRef) {
      this.modalRef.close();
    }
  }

  private loadMessageDetails(messageId: number) {
    this.messageService.getDetails(messageId).subscribe((data) => {
      this.message.set(data);
    });
  }
}
