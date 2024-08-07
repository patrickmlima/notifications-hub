import { Component, inject, OnInit, signal, TemplateRef } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import {
  Category,
  CategoryViewDto,
} from '../../../shared/types/categories.type';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-new-message',
  standalone: true,
  imports: [],
  templateUrl: './new-message.component.html',
  styleUrl: './new-message.component.css',
  providers: [CategoryService],
})
export class NewMessageComponent implements OnInit {
  private modalService = inject(NgbModal);
  private modalRef: NgbModalRef | undefined;

  categories = signal<CategoryViewDto[]>([]);

  constructor(private categoryService: CategoryService) {}

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
}
