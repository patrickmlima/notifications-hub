import { Component, inject, Input, TemplateRef } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-message-details',
  standalone: true,
  imports: [],
  templateUrl: './message-details.component.html',
  styleUrl: './message-details.component.css',
})
export class MessageDetailsComponent {
  private modalService = inject(NgbModal);
  private modalRef: NgbModalRef | undefined;

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {}

  open(content: TemplateRef<any>) {
    this.modalRef = this.modalService.open(content);
  }

  close() {
    if (this.modalRef) {
      this.modalRef.close();
    }
  }
}
