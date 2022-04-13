import { TestBed } from '@angular/core/testing';

import { BrasseurService } from './brasseur.service';

describe('BrasseurService', () => {
  let service: BrasseurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BrasseurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
