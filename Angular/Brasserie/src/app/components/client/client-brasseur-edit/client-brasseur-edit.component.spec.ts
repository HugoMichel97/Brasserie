import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientBrasseurEditComponent } from './client-brasseur-edit.component';

describe('ClientBrasseurEditComponent', () => {
  let component: ClientBrasseurEditComponent;
  let fixture: ComponentFixture<ClientBrasseurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientBrasseurEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientBrasseurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
