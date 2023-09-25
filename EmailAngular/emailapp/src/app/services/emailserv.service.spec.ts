import { TestBed } from '@angular/core/testing';

import { EmailservService } from './emailserv.service';

describe('EmailservService', () => {
  let service: EmailservService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmailservService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
