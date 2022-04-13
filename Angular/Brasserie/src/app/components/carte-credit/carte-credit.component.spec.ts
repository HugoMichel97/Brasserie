import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteCreditComponent } from './carte-credit.component';

describe('CarteCreditComponent', () => {
  let component: CarteCreditComponent;
  let fixture: ComponentFixture<CarteCreditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarteCreditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarteCreditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
