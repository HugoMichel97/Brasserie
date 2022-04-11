import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvenenementListComponent } from './evenenement-list.component';

describe('EvenenementListComponent', () => {
  let component: EvenenementListComponent;
  let fixture: ComponentFixture<EvenenementListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvenenementListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvenenementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
