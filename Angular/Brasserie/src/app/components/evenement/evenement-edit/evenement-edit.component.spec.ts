import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvenementEditComponent } from './evenement-edit.component';

describe('EvenementEditComponent', () => {
  let component: EvenementEditComponent;
  let fixture: ComponentFixture<EvenementEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvenementEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvenementEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
