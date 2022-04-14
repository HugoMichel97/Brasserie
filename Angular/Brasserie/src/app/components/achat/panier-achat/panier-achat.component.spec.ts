import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanierAchatComponent } from './panier-achat.component';

describe('PanierAchatComponent', () => {
  let component: PanierAchatComponent;
  let fixture: ComponentFixture<PanierAchatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanierAchatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanierAchatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
