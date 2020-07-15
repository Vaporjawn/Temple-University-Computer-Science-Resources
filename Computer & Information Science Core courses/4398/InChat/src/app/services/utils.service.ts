import {Injectable} from '@angular/core';
import {AngularFirestore} from '@angular/fire/firestore';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class UtilsService {
  constructor(private db: AngularFirestore, private afAuth: AuthService) { }

  getDocIds(collection: string) {
    return this.db.collection(collection).valueChanges({idField: 'ids'});
  }
}
