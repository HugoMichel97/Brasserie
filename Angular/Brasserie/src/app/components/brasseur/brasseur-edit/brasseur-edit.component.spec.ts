import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrasseurEditComponent } from './brasseur-edit.component';

describe('BrasseurEditComponent', () => {
  let component: BrasseurEditComponent;
  let fixture: ComponentFixture<BrasseurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrasseurEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrasseurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
