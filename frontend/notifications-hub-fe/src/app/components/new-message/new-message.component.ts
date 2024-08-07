import {
  Component,
  EventEmitter,
  inject,
  OnInit,
  Output,
  signal,
  TemplateRef,
} from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import {
  Category,
  CategoryViewDto,
} from '../../../shared/types/categories.type';
import { MessageCreateDto } from '../../../shared/types/message.type';
import { CategoryService } from '../../services/category.service';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-new-message',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './new-message.component.html',
  styleUrl: './new-message.component.css',
  providers: [CategoryService],
})
export class NewMessageComponent implements OnInit {
  @Output() onCreateMessage = new EventEmitter();

  private modalService = inject(NgbModal);
  private modalRef: NgbModalRef | undefined;

  categories = signal<CategoryViewDto[]>([]);

  formData = new FormGroup({
    body: new FormControl('', {
      validators: [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(1024),
      ],
    }),
    categoryId: new FormControl('', { validators: [Validators.required] }),
  });

  constructor(
    private categoryService: CategoryService,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.categoryService.getAll().subscribe((data: Category[]) => {
      this.categories.set(data.map((item) => item as CategoryViewDto));
    });
  }

  open(content: TemplateRef<any>) {
    this.modalRef = this.modalService.open(content);
  }

  close() {
    if (this.modalRef) {
      this.modalRef.close();
    }
  }

  submitForm() {
    const data: MessageCreateDto = {
      body: this.formData.get('body')?.value ?? '',
      categoryId: parseInt(this.formData.get('categoryId')?.value ?? '0', 10),
    };

    this.messageService.create(data).subscribe(() => {
      this.close();
      this.formData.reset();
      if (this.onCreateMessage) {
        this.onCreateMessage.emit();
      }
    });
  }
}
