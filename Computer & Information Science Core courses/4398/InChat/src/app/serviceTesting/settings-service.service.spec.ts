import {TestBed} from '@angular/core/testing';

import {SettingsService} from '../services/settings.service';

describe('SettingsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SettingsService = TestBed.get(SettingsService);
    expect(service).toBeTruthy();
  });
});
