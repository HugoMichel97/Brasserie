import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoteClientComponent } from './note-client.component';

describe('NoteClientComponent', () => {
  let component: NoteClientComponent;
  let fixture: ComponentFixture<NoteClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoteClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoteClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
