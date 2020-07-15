import {TestBed} from '@angular/core/testing';

import {FriendsService} from '../services/friends.service';

describe('FriendsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FriendsService = TestBed.get(FriendsService);
    expect(service).toBeTruthy();
  });
});
